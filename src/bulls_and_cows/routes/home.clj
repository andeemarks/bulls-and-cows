(ns bulls-and-cows.routes.home
  (:use compojure.core)
  (:require [bulls-and-cows.views.layout :as layout]
            [bulls-and-cows.views :as views]
            [ring.util.response :as response]
            [taoensso.timbre :as timbre
             :refer (trace debug info warn error fatal spy)]
            [bulls-and-cows.model.core :as core]
            [bulls-and-cows.util :as util]))

(defn home-page []
  (layout/render
    "home.html" {:content (util/md->html "/md/docs.md")}))

(defn about-page []
  (layout/render "about.html"))

(defn start-page []
  (layout/render "header.html" {:content (views/guess-form)}))

(defn evaluate-guess [guess]
  (info "Guess: " guess ", answer: " (core/guess-number '(1 2 3 4) guess))
  (response/redirect "/start"))
 
  
(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/submit-guess" [guess] (evaluate-guess guess))
  (GET "/start" [] (start-page))
  (GET "/about" [] (about-page)))
