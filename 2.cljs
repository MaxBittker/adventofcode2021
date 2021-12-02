(require '[planck.core :refer [line-seq with-open]]
         '[planck.io :as io]
         '[planck.core :as core]
         '[planck.shell :as shell]
         '[clojure.string :as string])

(def input
  (string/split
   (core/slurp "./2.txt")
   #"\n"))

(defn parse-line [line]
  (let  [[command v] (string/split line " ")]
    [command (js/parseInt v 10)]))

(def commands (map parse-line input))

(defn f-component
  [[c v]]
  (* v
    (if (= c "forward") 
      1 0)))

(def forwards 
  (map f-component
    commands))

(def x 
  (apply + forwards))

(defn y-component
  [[c v]]
  (* v
    (cond
    (= c "up") -1
    (= c "down") 1
    :else 0)))

(def aims 
  (reductions 
    +
    (map y-component
      commands)))

(def y 
  (reduce + 
    (map * 
      forwards 
      aims)))


(println x)
(println y)

(println (* x y))
