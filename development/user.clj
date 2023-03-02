(ns user
  (:require [lambdaisland.classpath.watch-deps :as watch-deps]
            [hyperfiddle.rcf]))

(watch-deps/start! {:aliases [:dev :test]})

(hyperfiddle.rcf/enable!)
