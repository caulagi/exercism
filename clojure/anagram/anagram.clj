;;;; Anagram
;;;;
;;;; Write a program that, given a word and a list of possible anagrams,
;;;; selects the correct sublist.
;;;;
;;;; Given `"listen"` and a list of candidates like `"enlists" "google"
;;;; "inlets" "banana"` the program should return a list containing
;;;; `"inlets"`.
;;;;
(ns anagram
  (:use [clojure.string :only [lower-case]]))

(defn- copy-but [word n]
  "Return all characters in the string except the one at n"
  (apply str (concat (take n word) (nthrest word (inc n)))))

(defn- indexof
  "Return index of first character of w1 in w2"
  [w1 w2]
  (.indexOf w2 (str (first w1))))

(defn- anagram-insensitive
  "Whether w2 is an anagram of w1"
  [w1 w2]
  (cond
    (not= (count w1) (count w2)) false
    (empty? w1) true
    (= w1 w2) false
    (= (indexof w1 w2) -1) false
    :else (recur (rest w1) (copy-but w2 (indexof w1 w2)))))

(defn- anagram? 
  "Whether w2 is an anagram of w1"
  [w1 w2]
  (anagram-insensitive (lower-case w1) (lower-case w2)))

(defn anagrams-for [word candidates]
  (filter (partial anagram? word) candidates))
