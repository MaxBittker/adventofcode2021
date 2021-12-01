
(ns aoc.one
  (:require-macros lumo.util)
  (:require [clojure.string :as string]
            [clojure.set :as set]
            [cljs.js :as cljs]
            [cljs.compiler :as comp]
            [cljs.reader :as edn]
            [goog.string :as gstring]
            [lumo.io :as io]
            fs
            path
            os))

(def input
  (string/split
  ;  (io/slurp "./example_input1.txt")
   (io/slurp "./input1.txt")
   #"\n"))

(def values
  (map #(js/parseInt % 10) input))

(def freqs
  (reductions + (cycle  values)))

(def distinct-freqs
  (map vector
       (distinct freqs)
       freqs))

(println
 (second
  (first
   (filter
    #(not (apply = %))
    distinct-freqs))))
