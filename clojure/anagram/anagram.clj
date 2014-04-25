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

(defn- anagram-insensitive
  "Whether word2 is an anagram of word1"
  [word1 word2]
  (cond
    (not= (count word1) (count word2)) false
    (empty? word1) true
    (= word1 word2) false
    (= (.indexOf word2 (str (first word1))) -1) false
    :else (anagram-insensitive (rest word1)
                               (copy-but word2 (.indexOf word2 (str (first word1)))))))

(defn- anagram? 
  "Whether word2 is an anagram of word1"
  [word1 word2]
  (anagram-insensitive (lower-case word1) (lower-case word2)))

(defn anagrams-for [word candidates]
  (filter (partial anagram? word) candidates))
