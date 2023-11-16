(ns hacker-rank.equal
  "https://www.hackerrank.com/challenges/equal/problem
   https://jacegem.github.io/blog/2023/2023-11-16-clojure-hacker-rank-equal/
   ")

(def count-map {0 0
                1 1
                2 1
                3 2
                4 2
                5 1})

(defn op-count [n]
  (loop [cnt n
         acc 0]
    (if-let [val (count-map cnt)]
      (+ acc val)
      (recur (- cnt 5) (inc acc)))))

(defn equal [arr]
  (->> (map #(- % (apply min arr)) arr)
       (map op-count)
       (reduce +)))

(equal [2 2 3 7])
