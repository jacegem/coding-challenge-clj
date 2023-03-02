(ns advent-of-code.2021.day-01
  (:require [cc.advent-of-code.core :refer [read-numbers]]
            [clojure.test :refer [run-tests]]
            [hyperfiddle.rcf :refer [tests]]))

;; https://adventofcode.com/2021/day/1
;; --- Day 1: Sonar Sweep ---

(def sample [199
             200
             208
             210
             200
             207
             240
             269
             260
             263])

(def input (read-numbers 2021 01))

(defn part-1 [input]
  (->> input
       (partition 2 1)
       (map #(< (first %) (second %)))
       (filter true?)
       count))

(tests
 (part-1 sample) := 7
 (part-1 input) := 1766
 :rcf)

;; part 2
(defn part-2 [input]
  (->> input
       (partition 3 1)
       (map #(apply + %))
       (partition 2 1)
       (map #(< (first %) (second %)))
       (filter true?)
       count))

(tests
 (part-2 sample) := 5
 (part-2 input) := 1797
 :rcf)
