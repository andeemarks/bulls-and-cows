(ns bulls_and_cows.core)

(defn generate-number []
  (take 4 (shuffle (range 10))))

(defn- find-bulls [correct-answer guess]
  (let [zipped-guess-and-answer (map list correct-answer guess)
        bull-count (count
                    (filter (fn[x] (= (first x) (second x)))
                            zipped-guess-and-answer))]
    (repeat bull-count :bull)))

(defn- find-cows [correct-answer guess bull-count]
  (let [cow-count (-
                   (count (clojure.set/intersection
                           (set correct-answer)
                           (set guess)))
                   (count bull-count))]
    (repeat cow-count :cow)))

(defn guess-number [correct-answer guess]
  (let [guess-as-seq (map #(Character/digit % 10) (str guess))
        bulls (find-bulls correct-answer guess-as-seq)
        cows (find-cows correct-answer guess-as-seq bulls)
        score (conj bulls cows)]
    (flatten score)))
