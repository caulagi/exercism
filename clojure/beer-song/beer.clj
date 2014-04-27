;;;; Beer Song
;;;;
;;;; Write a program which produces the lyrics to that beloved classic,
;;;; that field-trip favorite: 99 Bottles of Beer on the Wall.
;;;;
;;;; Note that not all verses are identical.

(ns beer
  (:use [clojure.string :only [join]]))

(def verse-with-placeholder
  "%1$s of beer on the wall, %1$s of beer.\nTake one down and pass it around, %2$s of beer on the wall.\n")

(defn- pluralize [n]
  "Get the number of bottles, properly pluralized"
  (cond
    (= n 1) (format "%s bottle" n)
    (= n 0) (str "no more bottles")
    :else (format "%s bottles" n)))

(defn- repeat-verse
  ([n] (format verse-with-placeholder (pluralize n) (pluralize (dec n))))
  ([] "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"))

(defn- restart-verse
  []
  "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n")

(defn verse [n]
  (cond
    (= n 0) (restart-verse)
    (= n 1) (repeat-verse)
    :else (repeat-verse n)))

(defn sing 
  ([start] (sing start 0))
  ([start stop] (loop [start start song '()]
                      (if (= start stop)
                          (join "\n" (reverse (cons (verse start) song)))
                          (recur (dec start) (cons (verse start) song))))))
