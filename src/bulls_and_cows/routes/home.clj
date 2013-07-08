(ns bulls-and-cows.routes.home
  (:use compojure.core)
  (:require [bulls-and-cows.views.layout :as layout]
            [bulls-and-cows.util :as util]))

(defn home-page []
  (layout/render
    "home.html" {:content (util/md->html "/md/docs.md")}))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page)))
