(ns excercism.hello-world-test
  (:require [clojure.test :refer [deftest is run-tests]]
            [excercism.hello-world :as hello-world]))

(deftest hello-world-test
  (is (= "Hello, World!" (hello-world/hello))))

(run-tests)
