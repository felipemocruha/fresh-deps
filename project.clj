(defproject fresh-deps "0.1.0-SNAPSHOT"
  :description "Dependency checker"
  :url "https://github.com/felipemocruha/fresh-deps"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [clj-http "3.9.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler fresh-deps.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
