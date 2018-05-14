(ns fresh-deps.core
  (:require [clj-http.client :as cli]))

(defmulti make-url (fn [type & _] type))

(defmethod make-url :python [_ pkg-name]
  (format "https://pypi.python.org/pypi/%s/json" pkg-name))

(defmethod make-url :nodejs [_ pkg-name]
  (format "https://api.npms.io/v2/package/%s" pkg-name))

(defmulti fetch-latest (fn [type & _] type))

(defmethod fetch-latest :python [_ pkg-name]
  (let [url (make-url :python pkg-name)]
    (-> (cli/get url {:as :json})
        :body
        :info
        :version)))

(defmethod fetch-latest :nodejs [_ pkg-name]
  (let [url (make-url :nodejs pkg-name)]
    (-> (cli/get url {:as :json})
        :body
        :collected
        :metadata
        :version)))

(defn outdated? [type pkg version]
  (not= version (fetch-latest type pkg)))
