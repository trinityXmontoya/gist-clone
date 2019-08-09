(ns gist-clone.database.schema
  ;(:gen-class)
  (:require [datomic.client.api :as d]))

(def user-schema [;email
                  {:db/ident :user/email
                   :db/valueType :db.type/string
                   :db/cardinality :db.cardinality/one}
                  ;validation
                  {:db/ident :user/validate
                   :db.entity/attrs [:user/email]}])

(def gist-schema [;name
                  {:db/ident :gist/name
                   :db/valueType :db.type/string
                   :db/cardinality :db.cardinality/one}
                  ;owner_id
                  {:db/ident :gist/owner_id
                   :db/valueType :db.type/ref
                   :db/cardinality :db.cardinality/one}
                  ;validation
                  {:db/ident :gist/validate
                   :db.entity/attrs [:gist/name :gist/owner_id]}])

(def file-revision-schema [;revision-type
                           {:db/ident :file-revision/revision-type
                            :db/valueType :db.type/ref
                            :db/cardinality :db.cardinality/one}
                           ;revision-type enum options
                           {:db.ident :revision-type/create}
                           {:db.ident :revision-type/edit}
                           {:db.ident :revision-type/delete}])

(def database-schema
  (conj user-schema gist-schema file-revision-schema))