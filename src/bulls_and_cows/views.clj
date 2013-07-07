(ns bulls_and_cows.views
  (:use [hiccup core page]))

(defn index-page []
  (html5
    [:head
      [:title "BULLS and COWS"]
      (include-css "/css/style.css")]
    [:body
      [:h1 "BULLS and COWS"]]))
