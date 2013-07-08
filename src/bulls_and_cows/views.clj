(ns bulls-and-cows.views
  (:use [hiccup element core page form]))

(defn guess-form []
  (html5
   (form-to [:post "/submit-guess"]
            (text-field :guess)
            (submit-button "Try this!"))))
