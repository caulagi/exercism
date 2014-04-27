;;;; Write a program that given a phrase can count the occurrences
;;;; of each word in that phrase.
;;;;
;;;; For example for the input `"olly olly in come free"`
;;;;
;;;; olly: 2
;;;; in: 1
;;;; come: 1
;;;; free: 1

(ns word-count
  (:use [clojure.string :only [split lower-case blank?]]))

(defn- tokenize [sentence]
  "Return a list of words in the sentence in lower-case"
  (split (lower-case sentence) #"\W+"))

(defn- process-word [word bucket]
  "Update the word count in the bucket"
  (merge bucket {word (inc (get bucket word 0))}))

(defn word-count [str]
  (loop [words (tokenize str) result {}]
    (if (empty? words)
      result
      (recur (rest words) (process-word (first words) result)))))
