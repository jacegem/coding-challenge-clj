(ns the-joy-of-clojure.chap-9-2)

(defn build-move [& pieces]
  (apply hash-map pieces))

(build-move :from "e7" :to "e8" :promotion \Q)
;=> {:from "e7", :promotion \Q, :to "e8"}

(defrecord Move [from to castle? promotion]
  Object
  (toString [this]
    (str "Move " (:from this)
         " to " (:to this)
         (if (:castle? this)
           " castle"
           (if-let [p (:promotion this)]
             (str " promote to " p)
             "")))))

(str (Move. "e2" "e4" nil nil))
;=> "Move e2 to e4"
(.println System/out (Move. "e7" "e8" nil \Q))
; Move e7 to e8 promote to Q

#_{:clj-kondo/ignore [:redefined-var]}
(defn build-move [& {:keys [from to castle? promotion]}]
  {:pre [from to]}
  (Move. from to castle? promotion))

(str (build-move :from "e2" :to "e4"))
;=> "Move e2 to e4"


