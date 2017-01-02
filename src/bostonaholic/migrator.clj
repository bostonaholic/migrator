(ns bostonaholic.migrator
  (:require [bostonaholic.migrator.migrations :refer [first-migration]]
            [clojure.tools.namespace.find :refer [find-namespaces-in-dir]]
            [sipocone.components.migrator :as migrator])
  (:import (java.io File)))

(defn find-migrations [path]
  (->> path
       (File.)
       find-namespaces-in-dir
       (map (comp
             var-get
             #(ns-resolve % 'migration)
             #(doto % require)))))

(defn run* [db migrations direction]
  (doall (for [migration migrations]
           (do (println ";; Running migration:" (:name migration))
               ((direction migration) db)
               (j/insert! db :migrations {:number (:number migration)})))))

(defn run!
  ""
  ([db path] (run! db path :up))
  ([db path direction]
   (run* db
     (conj (find-migrations path)
           first-migration)
     direction)))
