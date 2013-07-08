(ns bulls-and-cows.routes.home
  (:use compojure.core)
  (:require [bulls-and-cows.views.layout :as layout]
            [bulls-and-cows.views :as views]
            [bulls-and-cows.util :as util]))

(defn home-page []
  (layout/render
    "home.html" {:content (util/md->html "/md/docs.md")}))

(defn about-page []
  (layout/render "about.html"))

(defn start-page []
  (layout/render "header.html" {:content (views/guess-form)}))
  
(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/start" [] (start-page))
  (GET "/about" [] (about-page)))
