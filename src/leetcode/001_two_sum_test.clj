(ns leetcode.001-two-sum-test
  (:require [clojure.test :refer [are deftest run-tests testing]]
            [leetcode.001-two-sum :refer [two-sum]]))

(deftest two-sum-test
  (testing "sample test"
    (are [x y] (= x y)
      (two-sum [2 7 11 15] 9) [0, 1]
      (two-sum [3 2 4] 6) [1, 2]
      (two-sum [3 3] 6) [0,1])))

(run-tests)
