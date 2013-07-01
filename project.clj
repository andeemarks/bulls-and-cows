(defproject bulls-and-cows "0.0.1-SNAPSHOT"
  :description "Cool new project to do things and stuff"
  :dependencies [[org.clojure/clojure "1.4.0"]]
  :plugins [[lein-expectations "0.0.7"]]
  :profiles {:dev {:dependencies [
                                  [expectations "1.4.49"]
                                  [midje "1.6-alpha2"]
                                  ]}})
  
