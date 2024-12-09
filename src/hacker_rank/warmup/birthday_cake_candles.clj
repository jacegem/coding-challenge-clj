(ns hacker-rank.warmup.birthday-cake-candles)

(def candles [4 4 1 3])

(->> (frequencies candles)
     (sort-by first)
     (reverse)
     (first)
     (second))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def candles-count (Integer/parseInt (clojure.string/trim (read-line))))

(def candles (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

;; (def result (birthdayCakeCandles candles))

;; (spit fptr (str result "\n") :append true)

(->> (map vector [9 2 3] [4 5 6])
     (filter (fn [[a b]]
               (> a b)))
     count)
