(ns bulls_and_cows.t-core
  (:use midje.sweet)
  (:require [bulls_and_cows.core :as core]))

(facts "the rules of bulls and cows"
       (facts "when generating numbers"
              (let [generated-numbers #{}]
                (facts "for each number generated"
                       (dotimes [_ 100]
                         (let [number (core/generate-number)]
                           (fact "the length of the number should be 4"
                                 ;;(println (conj (list number) generated-numbers))
                           (fact "the number should be entirely numeric"
                                 (filterv #(re-find #"[0-9]" (str %)) number) => number
                                 )
                           (fact "the number should contain unique digits"
                                 (count (set number)) => (count number)
                                 )))))
                (future-fact "the numbers should vary from call to call"
                      (count generated-numbers) => 100)
                ))
       (future-facts "when guessing numbers"
                     (facts "with no correct digits"
                            (fact "nothing should be returned"))
                     (facts "with a correct digit"
                            (fact "a bull should be returned when the digit is in the correct position")
                            (fact "a cow should be returned when the digit is in an incorrect position")
                            )
                     (facts "with several correct digits"
                            (fact "a set of bulls and cows should be returned"))
                     ))
