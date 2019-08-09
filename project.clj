(defproject gist-clone "0.1.0-SNAPSHOT"
  :description "clone of gist.github.com"
  :url "https://github.com/trinityXmontoya/gist-clone"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [com.datomic/client-pro "0.8.28"]]
  :main ^:skip-aot gist-clone.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
