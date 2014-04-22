;;;; Rna Transcription
;;;;
;;;; Write a program that, given a DNA strand, returns its RNA
;;;; complement (per RNA transcription).
;;;;
;;;; Both DNA and RNA strands are a sequence of nucleotides.
;;;; The four nucleotides found in DNA are adenine (**A**),
;;;; cytosine (**C**), guanine (**G**) and thymidine (**T**).
;;;;
;;;; The four nucleotides found in RNA are adenine (**A**),
;;;; cytosine (**C**), guanine (**G**) and uracil (**U**).
;;;; 
;;;; Given a DNA strand, its transcribed RNA strand is formed
;;;; by replacing each nucleotide with its complement:
;;;;
;;;; * `G` -> `C`
;;;; * `C` -> `G`
;;;; * `T` -> `A`
;;;; * `A` -> `U`

(ns dna)

(defn- transcribe [strand]
  "Transcribe this single RNA strand"
  (case strand
    \G \C
    \C \G
    \T \A
    \A \U
    (throw (AssertionError. "What are you doing?!"))))

(defn to-rna [strand]
  (loop [str (clojure.string/reverse strand) seq '()]
    (if (empty? str)
      (clojure.string/join "" seq)
      (recur (rest str)
        (cons (transcribe (first str)) seq)))))
