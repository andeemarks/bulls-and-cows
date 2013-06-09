(ns bulls_and_cows.t-core
  (:use midje.sweet)
  (:require [bulls_and_cows.core :as core]))

(facts "the rules of bulls and cows"
       (fact "the length of the number should be 4"
             (let [number (core/generate-number)]
               (count number) => 4))
       (fact "the number should be entirely numeric"
             (let [number (core/generate-number)]
               (filterv #(re-find #"[0-9]" (str %)) number) => number
               ))
       (fact "the number should contain unique digits"
             (let [number (core/generate-number)]
               (count (set number)) => (count number)
               ))
       (fact "the number should vary from call to call"
             (let [number1 (core/generate-number)
                   number2 (core/generate-number)]
               (= number1 number2) => :falsey))
       )
