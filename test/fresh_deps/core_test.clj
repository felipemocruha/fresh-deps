(ns fresh-deps.core-test
  (:require [clojure.test :refer :all]
            [fresh-deps.core :refer :all]))

(deftest test-make-url-python
  (is (= "https://pypi.python.org/pypi/numpy/json"
         (make-url :python "numpy"))))

(deftest test-make-url-nodejs
  (is (= "https://api.npms.io/v2/package/react"
         (make-url :nodejs "react"))))

(deftest test-fetch-latest-python
  (is (= "1.14.3"
         (fetch-latest :python "numpy"))))
