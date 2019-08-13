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

(def commit-schema [;description
                    {:db/ident :gist/description
                     :db/valueType :db.type/string
                     :db/cardinality :db.cardinality/one}
                    ;validation
                    {:db/ident :gist/validate
                     :db.entity/attrs [:gist/description]}])

(def gist-revision-schema [;commit_id
                    {:db/ident :gist/commit_id
                     :db/valueType :db.type/ref
                     :db/cardinality :db.cardinality/one}
                    ;file_revision_id
                    {:db/ident :gist/file_revision_id
                     :db/valueType :db.type/ref
                     :db/cardinality :db.cardinality/one}])

(def file-schema [;filename
                  {:db/ident :gist/filename
                   :db/valueType :db.type/ref
                   :db/cardinality :db.cardinality/one}
                   ;file_contents
                  {:db/ident :file-revision/file_contents
                   :db/valueType :db.type/string
                   :db/cardinality :db.cardinality/one}])

(def file-revision-schema [;file_id
                           {:db/ident :gist/file_id
                            :db/valueType :db.type/ref
                            :db/cardinality :db.cardinality/one}
                           ;revision-type
                           {:db/ident :file-revision/revision_type
                            :db/valueType :db.type/ref
                            :db/cardinality :db.cardinality/one}
                           ;revision-type enum options
                           {:db.ident :revision_type/create}
                           {:db.ident :revision_type/edit}
                           {:db.ident :revision_type/delete}])

;user has_many gists
;gist has_many files through: gist_files
;file has_many commits through: revisions
;file has_many file_revisions through: revisions


(def database-schema
  (conj user-schema
        gist-schema
        file-schema
        commit-schema
        gist-revision-schema
        file-revision-schema))