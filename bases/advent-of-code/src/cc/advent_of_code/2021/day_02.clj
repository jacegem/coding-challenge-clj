(ns cc.advent-of-code.2021.day-02
  (:require [cc.advent-of-code.core :refer [read-lines]]))

;; https://adventofcode.com/2021/day/2
;; --- Day 2: Dive! ---

(def sample ["forward 5"
             "down 5"
             "forward 8"
             "up 3"
             "down 8"
             "forward 2"])

(def input (read-lines 2021 02))

(defn read-data [input]
  (->> input
       (re-seq #"(\w+) (\d+)")
       (mapcat (fn [[_ cmd x]]
                 [(keyword cmd) (parse-long x)]))))

(defn step-1
  "forward X increases the horizontal position by X units.
  down X increases the depth by X units.
  up X decreases the depth by X units."
  [[hpos depth] [cmd x]]
  (case cmd
    :forward [(+ hpos x) depth]
    :up      [hpos (- depth x)]
    :down    [hpos (+ depth x)]))

(defn part-1 [input]
  (->> input
       (map read-data)
       (reduce step-1 [0 0])
       (apply *)))

(comment
  (map read-data sample)
  (part-1 sample)
  (part-1 input)
  :rcf)

(defn step-2
  "down X increases your aim by X units.
  up X decreases your aim by X units.
  forward X does two things:
      It increases your horizontal position by X units.
      It increases your depth by your aim multiplied by X."
  [[h-pos depth aim] [cmd x]]
  (case cmd
    :forward [(+ h-pos x) (+ depth (* aim x)) aim]
    :up      [h-pos depth (- aim x)]
    :down    [h-pos depth (+ aim x)]))

(defn part-2 [input]
  (->> input
       (map read-data)
       (reduce step-2 [0 0 0])
       (take 2)
       (apply *)))

(comment
  (part-2 input)
  :rcf)
