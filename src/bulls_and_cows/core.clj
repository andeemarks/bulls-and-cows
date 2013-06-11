(ns bulls_and_cows.core)

(defn generate-number []
  (take 4 (shuffle (range 10))))

(defn compare-respective-digits [answer-digit guess-digit]
  (if (= answer-digit guess-digit)
    '(:bull)))

(defn find-bulls [number guess]
  (let [digit-from-answer (first number)
        digit-from-guess (first guess)]
    (if digit-from-answer
      (flatten (conj
                (compare-respective-digits digit-from-answer digit-from-guess)
                (find-bulls (rest number) (rest guess)))))))

(defn find-cows [number guess found-bulls]
  (let [number-cows (-
                     (count (clojure.set/intersection (set number) (set guess)))
                     (count found-bulls))]
    (repeat number-cows :cow)))

(defn guess-number [number guess]
  (let [guess-as-seq (map #(Character/digit % 10) (str guess))]
    (let [bulls (remove nil? (find-bulls number guess-as-seq))
          cows (find-cows number guess-as-seq bulls)
          score (conj bulls cows)]
      (flatten score))))
