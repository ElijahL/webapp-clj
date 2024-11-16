(defproject webapp-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]

                 ;; basic Ring and web server:
                 [ring/ring-core "1.12.2"]
                 [ring/ring-jetty-adapter "1.12.2"]

                 ;; logging, required by jetty:
                 [org.slf4j/slf4j-simple "2.0.13"]

                 ;; routing:
                 [compojure/compojure "1.7.1"]

                 ;; convenient package of "default" middleware:
                 [ring/ring-defaults "0.5.0"]

                 ;; to generate HTML:
                 [hiccup/hiccup "1.0.5"]

                 ;; for the database:
                 [com.github.seancorfield/next.jdbc "1.3.939"]
                 [com.h2database/h2 "2.2.224"]]

  :main ^:skip-aot webapp-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
