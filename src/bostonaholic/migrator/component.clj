(ns bostonaholic.migrator.component
  (:require [bostonaholic.migrator :as m]
            [com.stuartsierra.component :as component]))

(defrecord Migrator [migrations-path database]
  component/Lifecycle

  (start [this]
    (println ";; Starting migrator")
    (m/run! migrations-path (:db-spec database) :up)
    this)

  (stop [this]
    (println ";; Stopping migrator")
    this))

(defn new-migrator [migrations-path]
  (map->Migrator {:migrations-path migrations-path}))
