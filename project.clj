(defproject com.rpl/rama-clojure-starter "1.0.0-SNAPSHOT"
  :dependencies [
                 [org.clojure/clojure "1.11.1"]
                 [com.rpl/rama-helpers "0.9.1"]
                 [mount "0.1.17"]
                 [com.taoensso/timbre "4.1.0"]
                 ]
  :repositories [["releases" {:id "maven-releases"
                              :url "https://nexus.redplanetlabs.com/repository/maven-public-releases"}]]

  :profiles {:dev {:source-paths ["dev" "dev/clj"]
                   :resource-paths ["test/resbources/"]}
             :provided {:dependencies [[com.rpl/rama "0.10.0"]
                                       [org.clojure/tools.namespace "1.4.4"]
                                       
                                       ]
                        }}
  :plugins [[cider/cider-nrepl "0.40.0"]]
  )
