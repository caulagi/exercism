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
  "Return the count of nucleotides when it is valid"
  [acc nucleotide]
  (if (contains? acc nucleotide)
      (get acc nucleotide)
      (throw (Exception. "invalid nucleotide"))))

(defn- update-count
  "Update the count of nucleotide in the map"
  [acc nucleotide]
  (merge acc {nucleotide (inc (get-current-count acc nucleotide))}))

(defn nucleotide-counts
  [strand]
  (loop [strand strand acc {\A 0 \C 0 \G 0 \T 0}]
    (if (empty? strand)
        acc
        (recur (rest strand) (update-count acc (first strand))))))

(defn- valid-dna?
  "Whether the nucleotide is a valid one"
  [nucleotide]
  (contains? (set [\A \C \G \T \U]) nucleotide))

(defn- count-nucleotide?
  "Whether we need to add this nucleotide to the sum?"
  [current other]
  (if (= current other) 1 0))
    
(defn count
  ([nucleotide] 0)
  ([nucleotide strand]
    (if (not (valid-dna? nucleotide))
        (throw (Exception. "invalid nucleotide"))
        (reduce + (map (partial count-nucleotide? nucleotide) strand)))))
