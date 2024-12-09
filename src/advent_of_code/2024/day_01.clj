(ns advent-of-code.2024.day-01
  "https://adventofcode.com/2024/day/1
   --- Day 1: Historian Hysteria ---"
  (:require
   [advent-of-code.core :refer [read-lines]]))

(def sample ["3 4"
             "4 3"
             "2 5"
             "1 3"
             "3 9"
             "3 3"])

(defn sort-numbers [lines]
  (-> (reduce (fn [acc row]
                (let [[left right] (map parse-long (re-seq #"\d+" row))]
                  (-> acc
                      (update :left conj left)
                      (update :right conj right))))
              {:left  []
               :right []}
              lines)
      (update :left sort)
      (update :right sort)))

(comment
  (sort-numbers sample)
  :rcf)

(defn solve [lines]
  (let [numbers              (sort-numbers lines)
        {:keys [left right]} numbers]
    (->> (map vector left right)
         (map (fn [[l r]]
                (abs (- l r))))
         (apply +))))

(comment
  (solve sample) ;=> 10
  (sort-numbers sample)

  (def input (read-lines 2024 01))
  (solve input) ;=> 1970720

  (re-seq #"\d+" "3 4") ;=> ("3" "4")
  (zipmap [1 2] [3 4]) ;=> {1 3, 2 4}

  :rcf)
