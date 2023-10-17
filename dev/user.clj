(ns user
  (:require
   [clojure.pprint :refer [print-table pprint]]
   [clojure.tools.namespace.repl :as tn]
   [mount.core :as mount]
   [mount.tools.graph :refer [states-with-deps]]
   [taoensso.timbre :as timbre]
   [clojure.string :as str]

   [rama-clojure-starter.my-module :as mm]
   ))

(defn start []
  (timbre/set-config! (assoc timbre/example-config :level :error))
  (mount/start))

(defn stop []
  (mount/stop))

(defn refresh-all []
  (stop)
  (tn/refresh-all))

(defn reset []
  (stop)
  (tn/refresh :after 'user/start))

