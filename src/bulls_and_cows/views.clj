(ns bulls-and-cows.views
  (:use [hiccup element core page form]))

(defn guess-form []
  (html5
   (form-to [:post "/submit-guess"]
            (text-field :guess)
            (submit-button "Try this!"))))

(defn answer-form []
  (html5
   (form-to [:post "/submit-answer"]
            (text-field :answer)
            (submit-button "Enter answer"))))
