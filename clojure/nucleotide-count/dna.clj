;;;; Nucleotide Count
;;;;
;;;; Write a class `DNA` that takes a DNA string and tells us how many
;;;; times each nucleotide occurs in the string.
;;;;
;;;; DNA is represented by an alphabet of the following symbols: 'A', 'C',
;;;; 'G', and 'T'.
;;;;
;;;; Each symbol represents a nucleotide, which is a fancy name for the
;;;; particular molecules that happen to make up a large part of DNA.
;;;;
;;;; Shortest intro to biochemistry EVAR:
;;;; 
;;;; * twigs are to birds nests as
;;;; * nucleotides are to DNA and RNA as
;;;; * amino acids are to proteins as
;;;; * sugar is to starch as
;;;; * oh crap lipids
;;;;
;;;; I'm not going to talk about lipids because they're crazy complex.
;;;;
;;;; So back to nucleotides.
;;;; There are 5 types of nucleotides. 4 of these occur in DNA: 
;;;; `A`, `C`, `G`, and `T`. 4 occur in RNA: `A`, `C`, `G`, `U`.
;;;;
;;;; There are no other nucleotides.

(ns dna)

(defn- get-current-count
  [acc nucleotide]
  (if (contains? acc nucleotide)
      (get acc nucleotide)
      (throw (Exception. "invalid nucleotide"))))

(defn- update-count
  [acc nucleotide]
  (merge acc {nucleotide (inc (get-current-count acc nucleotide))}))

(defn nucleotide-counts
  [strand]
  (loop [strand strand acc {\A 0 \C 0 \G 0 \T 0}]
    (if (empty? strand)
        acc
        (recur (rest strand) (update-count acc (first strand))))))

(defn- valid-dna?
  [nucleotide]
  (contains? (set [\A \C \G \T \U]) nucleotide))

(defn count
  ([nucleotide] (count nucleotide ""))
  ([nucleotide strand]
    (cond
      (empty? strand) 0
      (not (valid-dna? nucleotide)) (throw (Exception. "invalid nucleotide"))
      :else (loop [strand strand acc 0]
                  (cond
                    (empty? strand) acc
                    (= nucleotide (first strand)) (recur (rest strand) (inc acc))
                    :else (recur (rest strand) acc))))))
