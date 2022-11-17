(ns cc.advent-of-code.core
  (:require [cc.input.interface :refer [read-file]]))

(defn read-lines [year day]
  (-> (format "advent-of-code/%d/day_%02d.txt" year day)
      read-file))

(defn read-numbers [year day]
  (->> (read-lines year day)
       (map parse-long)))
