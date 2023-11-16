(ns hacker-rank.equal
  "https://www.hackerrank.com/challenges/equal/problem
   https://see-ro-e.tistory.com/249
   ")

#_(def op-count
    (memoize (fn [n]
               (loop [cnt n
                      acc 0]
                 (condp = cnt
                   0 (+ 0 acc)
                   1 (+ 1 acc)
                   2 (+ 1 acc)
                   3 (+ 2 acc)
                   4 (+ 2 acc)
                   5 (+ 1 acc)
                   (recur (- cnt 5) (inc acc)))))))

(defn op-count [n]
  (loop [cnt n
         acc 0]
    (condp = cnt
      0 (+ 0 acc)
      1 (+ 1 acc)
      2 (+ 1 acc)
      3 (+ 2 acc)
      4 (+ 2 acc)
      5 (+ 1 acc)
      (recur (- cnt 5) (inc acc)))))

(defn equal [arr]
  (let [min-val (apply min arr)]
    (->> (map #(- % min-val) arr)
         (map op-count)
         (reduce +))))
