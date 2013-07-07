(defproject bulls-and-cows "0.0.1-SNAPSHOT"
  :description "Cool new project to do things and stuff"

  :dependencies [
                 [org.clojure/clojure "1.4.0"]
                 [hiccup "1.0.0"]
                 [compojure "1.1.5"]
                 ]

  :local-repo "local-m2"
  
  :plugins [[lein-ring "0.8.5"]
            [lein-deps-tree "0.1.2"]
            ]
  
  :ring {:handler bulls_and_cows.web/app}
  
  :profiles {:dev {:dependencies [
                                  [expectations "1.4.49"]
                                  [midje "1.6-alpha2"]
                                  ]}})
  
