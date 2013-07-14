(ns bulls-and-cows.routes.home
  (:use compojure.core)
  (:require [bulls-and-cows.views.layout :as layout]
            [bulls-and-cows.views :as views]
            [ring.util.response :as response]
            [taoensso.timbre :as timbre :refer (trace debug info warn error fatal spy)]
            [noir.session :as session]
            [bulls-and-cows.model.core :as core]
            [bulls-and-cows.util :as util]))

(defn home-page []
  (layout/render
    "home.html" {:content (util/md->html "/md/docs.md")}))

(defn about-page []
  (layout/render "about.html"))

(defn start-page []
  (layout/render "header.html" {:content (views/guess-form)}))

(defn enter-answer []
  (layout/render "header.html" {:content (views/answer-form)}))
  
(defn evaluate-guess [guess]
  (let [answer (map read-string (rest (clojure.string/split (session/get :answer) #"")))]
    (info "Guess: " guess ", answer: (" answer ") " (core/guess-number answer guess)))
  (response/redirect "/start"))
 
(defn record-answer [answer]
  (session/put! :answer answer)
  (response/redirect "/start"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/submit-guess" [guess] (evaluate-guess guess))
  (GET "/admin/answer" [] (enter-answer))
  (POST "/submit-answer" [answer] (record-answer answer))
  (GET "/start" [] (start-page))
  (GET "/about" [] (about-page)))
