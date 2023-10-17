(ns user
  (:use 
    [com.rpl.rama]
    [com.rpl.rama.path])
  (:require
   [clojure.pprint :refer [print-table pprint]]
   [clojure.tools.namespace.repl :as tn]
   [mount.core :as mount :refer [defstate]]
   [mount.tools.graph :refer [states-with-deps]]
   [taoensso.timbre :as timbre]
   [clojure.string :as str]

   [com.rpl.rama.aggs :as aggs]
   [com.rpl.rama.ops :as ops]
   [com.rpl.rama.test :as rtest]

   [style.mush.backend :as b]
   ))

(defstate ipc
  :start (rtest/create-ipc)
  :stop  (.close ipc))

(defn l [module-class]
  (rtest/launch-module! ipc module-class {:tasks 4 :threads 2}))

(defn d [module-class]
  (rtest/destroy-module! ipc (.getModuleName module-class)))

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

(defn r [] (reset))

