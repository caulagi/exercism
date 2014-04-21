;;;; Bob is a lackadaisical teenager. In conversation, his responses
;;;; are very limited.
;;;;
;;;; Bob answers 'Sure.' if you ask him a question.
;;;;
;;;; He answers 'Woah, chill out!' if you yell at him.
;;;;
;;;; He says 'Fine. Be that way!' if you address him without actually
;;;; saying anything.
;;;;
;;;; He answers 'Whatever.' to anything else.

(ns bob)

(defn- question? [str]
  "Return true if str ends with a ?"
  (= (last str) \?))

(defn- ascii-letter? [chr]
  "Return true if chr is an ascii character"
  (or
    (and (>= (int chr) (int \a)) (<= (int chr) (int \z)))
    (and (>= (int chr) (int \A)) (<= (int chr) (int \Z)))))

(defn- atleast-one-ascii? [str]
  "Return true if str contains atleast one ascii character"
  (> (count (filter ascii-letter? str)) 0))

(defn- yelling? [str]
  "Return true if the string only contains upper-case.
  except when string contains only numbers, in which case,
  return false"
  (and 
    (= str (clojure.string/upper-case str))
    (atleast-one-ascii? str)))

(defn response-for [str]
  (cond
    (clojure.string/blank? str) "Fine. Be that way!"
    (yelling? str) "Woah, chill out!"
    (question? str) "Sure."
    :else "Whatever."))
