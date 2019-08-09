(ns gist-clone.database.queries
  ;(:gen-class)
  (:require [datomic.client.api :as d]
            [gist-clone.database.config :as config]))

(def all-gists-by-user-query
  [user]
  (let [query '[:find ?entity
                :where [?entity :gist/owner_id (user :id)]]]
    (d/q query config/conn)))