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
  (:use [clojure.string :only [split lower-case]]))

(defn- allow-letter? [chr]
  "Whether chr is [a-zA-Z0-9] or space"
  (or
    (and (>= (int chr) (int \a)) (<= (int chr) (int \z)))
    (and (>= (int chr) (int \A)) (<= (int chr) (int \Z)))
    (and (>= (int chr) (int \0)) (<= (int chr) (int \9)))
    (= (int chr) (int \ ))))
  
(defn- depunctuate [sentence]
  "Return only ascii letters, numerals and spaces in the sentence"
  (apply str (filter allow-letter? sentence)))

(defn- tokenize [sentence]
  "Return a list of words in the sentence in lower-case"
  (split (lower-case (depunctuate sentence)) #"\s+"))

(defn- process-word [word bucket]
  "Update the word count in the bucket"
  (merge bucket {word (inc (get bucket word 0))}))

(defn word-count [str]
  (loop [words (tokenize str) result {}]
    (if (empty? words)
      result
      (recur (rest words) (process-word (first words) result)))))
