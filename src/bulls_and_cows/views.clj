(ns bulls_and_cows.views
  (:use [hiccup core page form]))

(defn guess-page []
  (html5
   [:head
    [:title "BULLS and COWS"]
    (include-css "/css/style.css")]
   [:body
    [:h1 "Your guess"]]))

(defn index-page []
  (html5
    [:head
      [:title "BULLS and COWS"]
      (include-css "/css/style.css")]
    [:body
     [:h1 "BULLS and COWS"]
     (form-to [:post "/guess"]
              (text-field :guess)
              (submit-button "Try this!"))]))
