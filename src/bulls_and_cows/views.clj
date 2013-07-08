(ns bulls-and-cows.views
  (:use [hiccup core page form]))

(defn guess-form []
  (html5
   (form-to [:post "/guess"]
            (text-field :guess)
            (submit-button "Try this!"))))
