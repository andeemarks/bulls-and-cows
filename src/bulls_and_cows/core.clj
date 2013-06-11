(ns bulls_and_cows.core)

(defn generate-number []
  (take 4 (shuffle (range 10))))

(defn compare-respective-digits [answer-digit guess-digit]
  (if (= answer-digit guess-digit)
    '(:bull)))

(defn determine-correctness [number guess]
  (let [digit-from-answer (first number)
        digit-from-guess (first guess)]
    (if digit-from-answer
      (flatten (conj
                (compare-respective-digits digit-from-answer digit-from-guess)
                (determine-correctness (rest number) (rest guess)))))))

(defn guess-number [number guess]
  (let [guess-as-seq (map #(Character/digit % 10) (str guess))]
    (let [correctness (determine-correctness number guess-as-seq)]
      (remove nil? correctness))))
