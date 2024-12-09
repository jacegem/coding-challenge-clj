(ns hacker-rank.warmup.compare-the-triplets)

(defn compare [ax bx]
  (map (fn [a b]
         {:alice (if (> a b) 1 0)
          :bob   (if (< a b) 1 0)})
       ax bx))

(defn calc-points [res]
  (reduce (fn [acc v]
            (let [a (:alice v)
                  b (:bob v)]
              (-> acc
                  (update :alice #(+ % a))
                  (update :bob #(+ % b)))))
          {:alice 0
           :bob   0}
          res))

(defn print-points [m]
  [(:alice m) (:bob m)])

(-> (compare [1 2 3] [3 2 1])
    (calc-points)
    (print-points))
