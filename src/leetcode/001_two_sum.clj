(ns leetcode.001-two-sum)

(defn two-sum [nums target]
  (let [indexes (range (count nums))]
    (-> (for [i     indexes
              j     indexes
              :when (and (not= i j)
                         (= target (+ (nth nums i)
                                      (nth nums j))))]
          [i j])
        first)))
