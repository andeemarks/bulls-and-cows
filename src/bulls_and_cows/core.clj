(ns bulls_and_cows.core)

(defn generate-number []
  (take 4 (shuffle (range 10))))

(defn guess-number [number guess]
  (let [correct? (= number (map #(Character/digit % 10) (str guess)))]
    (if correct?
      (repeat 4 :bull)
      nil))
  )
