(ns gist-clone.database.config
  ;(:gen-class)
  (:require [datomic.client.api :as d]
            [gist-clone.database.schema :as schema]))

(def db-config {:server-type :peer-server
                :access-key "myaccesskey"
                :secret "mysecret"
                :endpoint "localhost:8998"})

(def client (d/client db-config))

(def conn (d/connect client {:db-name "gist_clone"}))

; apply schema
;(d/transact conn {:tx-data schema/database-schema})