(ns cc.input.core
  (:require [clojure.java.io :as io]
            [clojure.string :refer [split-lines trim-newline]]))

(defn read-file [path]
  (-> path
      io/resource
      slurp
      trim-newline
      split-lines))
