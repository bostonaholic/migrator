(ns bostonaholic.migrator.migrations
  (:require [clojure.java.jdbc :as j]))

(def first-migration
  {:name "Create migrations table"
   :number "00000000000000" ;; yyyymmddhhmmss
   :up (fn [db] (j/execute! db
                            (j/create-table-ddl :migrations [[:number "varchar(14)" "not null"]])))

   :down (fn [db] (j/execute! db (j/drop-table-ddl :migrations)))})
