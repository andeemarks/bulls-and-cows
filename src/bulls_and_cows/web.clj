(ns bulls_and_cows.web
  (:use compojure.core
        bulls_and_cows.views)
  (:require [compojure.route :as route]
            [hiccup.middleware :as hiccup]
            [compojure.handler :as handler]
            ))

(defroutes main-routes
  (GET "/" [] (index-page))
  (POST "/guess" [] (guess-page))
  (route/not-found "<h1>Page not found</h1>"))

(def app
  (-> (handler/site main-routes)
      (hiccup/wrap-base-url)))
