(ns gist-clone.database.actions
  ;(:gen-class)
  (:require [datomic.client.api :as d]
            [gist-clone.database.config :as config]))

(defn build-gist
  [params]
  {:name (params :gist-name)
   :owner_id ((params :current-user) :id)})

(defn add-gist
  [params]
  (let [gist (build-gist params)]
    (d/transact config/conn {:tx-data [gist]})))
