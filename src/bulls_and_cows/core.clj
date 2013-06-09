(ns bulls_and_cows.core)

(defn generate-number []
  (take 4 (shuffle (range 10))))
