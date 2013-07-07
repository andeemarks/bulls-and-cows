(ns bulls_and_cows.core_test
  (:use expectations)
  (:require [
             bulls_and_cows.core :as core
             ]))

"when guessing numbers"
(expect () (core/guess-number '(1 2 3 4) "5678"))
(expect '(:bull :bull :bull :bull) (core/guess-number '(1 2 3 4) "1234"))
(expect '(:bull) (core/guess-number '(1 5 6 7) "1234"))
(expect '(:cow) (core/guess-number '(1 5 6 7) "2341"))
(expect '(:bull :cow :cow) (core/guess-number '(1 5 6 7) "1654"))
