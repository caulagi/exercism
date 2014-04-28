;;;; Phone Number
;;;;
;;;; Write a program that cleans up user-entered phone numbers so that
;;;; they can be sent SMS messages.
;;;;
;;;; The rules are as follows:
;;;;
;;;; * If the phone number is less than 10 digits assume that it is bad number
;;;; * If the phone number is 10 digits assume that it is good
;;;; * If the phone number is 11 digits and the first number is 1, trim the 1 and use the first 10 digits
;;;; * If the phone number is 11 digits and the first number is not 1, then it is a bad number
;;;; * If the phone number is more than 11 digits assume that it is a bad number

(ns phone)

(def invalid-number "0000000000")

(defn- validate-number
  [n]
  (cond
    (= (count n) 10) n
    (and (= (count n) 11)  (= (first n) "1")) (rest n)
    (and (= (count n) 11)  (not= (first n) "1")) invalid-number
    :else invalid-number))

(defn number
  [n]
  (apply str (validate-number (re-seq #"\w" n))))

(defn area-code
  [n]
  (apply str (take 3 n)))

(defn- take-three
  "Return the first 3 characters in the string"
  [n]
  (apply str (take 3 n)))

(defn pretty-print
  [n]
  (let [n (number n)]
       (format "(%s) %s-%s" 
               (take-three n)
               (take-three (take-last 7 n))
               (apply str (take-last 4 n)))))
