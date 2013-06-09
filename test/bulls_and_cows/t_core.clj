(ns bulls_and_cows.t-core
  (:use midje.sweet)
  (:require [bulls_and_cows.core :as core]))

(facts "the rules of bulls and cows"
       (facts "when generating numbers"
              (facts "for each number generated"
                     (dotimes [_ 100]
                       (let [number (core/generate-number)]
                         (fact "the length of the number should be 4"
                               (count number) => 4)
                         (fact "the number should be entirely numeric"
                               (filterv #(re-find #"[0-9]" (str %)) number) => number
                               )
                         (fact "the number should contain unique digits"
                               (count (set number)) => (count number)
                               )
                         (fact "the number should vary from call to call"
                               (let [number1 (core/generate-number)
                                     number2 (core/generate-number)]
                                 (= number1 number2) => false))
                             )))))
