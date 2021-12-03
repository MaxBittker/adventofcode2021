(require '[planck.core :refer [line-seq with-open]]
         '[planck.io :as io]
         '[planck.core :as core]
         '[planck.shell :as shell]
         '[clojure.string :as string])


(def input
  (string/split
   (core/slurp "./3.txt")
   #"\n"))

(defn transpose [v]
  (mapv (fn [ind]
          (mapv #(get % ind)
                (filter #(contains? % ind) v)))
        (->> (map count v)
             (apply max)
             range)))
(def values
  (map #(string/split % "") input))

(def freqs 
 (map frequencies
  (transpose values)))

(def gamma
 (map
  #(first (last (sort-by val %)))
   freqs))


(def epsilon
 (map
  #(first (first (sort-by val %)))
   freqs))

(defn decimal [bits]
  (reduce + 
        (map-indexed 
          (fn [i v] (* v (.pow js/Math 2 i)))
          (reverse bits))))

;; (println (decimal gamma))
;; (println  gamma)
;; (println (decimal epsilon))
;; (println epsilon)
;; (println (* (decimal gamma) (decimal epsilon)))


;; (defn reject
;;   [input]
;;   (if (= (count input) 0)
;;     input
;;     (let 
;;     (reject
;;        (filter 
        