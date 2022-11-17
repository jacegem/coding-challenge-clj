(ns cc.input.interface
  (:require [cc.input.core :as core]))

(defn read-file [path]
  (core/read-file path))
