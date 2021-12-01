(require '[planck.core :refer [line-seq with-open]]
         '[planck.io :as io]
         '[planck.core :as core]
         '[planck.shell :as shell]
         '[clojure.string :as string])

(def input
  (string/split
   (core/slurp "./1.txt")
   #"\n"))

(def values
  (map #(js/parseInt % 10) input))


(def pairs
 (partition 2 1 values))

(def triplets 
  (partition 3 1 values))

(def increasing
  (filter
   (fn [[a b]] (> 0 (- a b)))
   pairs))

(println (count increasing))

(def sums 
  (map 
   (fn [t] (reduce + t))
  triplets))

(def sum-pairs
  (partition 2 1 sums))

(def increasing-triplets
  (filter
   (fn [[a b]] (> 0 (- a b)))
   sum-pairs))

(println (count increasing-triplets))
