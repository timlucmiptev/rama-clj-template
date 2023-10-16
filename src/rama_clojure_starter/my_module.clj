(ns rama-clojure-starter.my-module
  (:use [com.rpl.rama]
        [com.rpl.rama.path])
  (:require [com.rpl.rama.aggs :as aggs]
            [com.rpl.rama.ops :as ops]
            [clojure.string :as str]))

(defmodule MyModule [setup topologies]
  )

(defmodule WordCountModule [setup topologies]
  (declare-depot setup *sentences-depot :random)
  (let [s (stream-topology topologies "word-count")]
    (declare-pstate s $$word-counts {String Long})
    (<<sources s
      (source> *sentences-depot :> *sentence)
      (str/split (str/lower-case *sentence) #" " :> *words)
      (ops/explode *words :> *word)
      (|hash *word)
      (+compound $$word-counts {*word (aggs/+count)})
)))
