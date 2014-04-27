;;;; Beer Song
;;;;
;;;; Write a program which produces the lyrics to that beloved classic,
;;;; that field-trip favorite: 99 Bottles of Beer on the Wall.
;;;;
;;;; Note that not all verses are identical.

(ns beer
  (:use [clojure.string :only [join]]))

(defn- pluralize [word n]
  (cond
    (= n 1) (format "%s %s" n word)
    (= n 0) (str "no more " word "s")
    :else (format "%s %ss" n word)))

(defn- repeat-verse
  ([] "%1$s of beer on the wall, %1$s of beer.\nTake one down and pass it around, %2$s of beer on the wall.\n")
  ([one] "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"))

(defn- restart-verse
  []
  "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n")

(defn verse [n]
  (cond
    (= n 0) (restart-verse)
    (= n 1) (repeat-verse 1)
    :else (format (repeat-verse) (pluralize "bottle" n) (pluralize "bottle" (dec n)))))

(defn sing 
  ([start] (sing start 0))
  ([start stop] (loop [start start song '()]
                      (if (= start stop)
                          (join "\n" (reverse (cons (verse start) song)))
                          (recur (dec start) (cons (verse start) song))))))
