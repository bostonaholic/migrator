(defproject bostonaholic/migrator "0.1.0-SNAPSHOT"
  :description "A Clojure library for database migrations."
  :url "https://github.com/bostonaholic/migrator"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/tools.namespace "0.3.0-alpha3"]

                 ;; components
                 [com.stuartsierra/component "0.3.2"]

                 ;; database
                 [org.clojure/java.jdbc "0.7.0-alpha1"]])
