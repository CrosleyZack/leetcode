(ns leetcode.flatten)

; Given a multi-dimensional array arr and a depth n, return a flattened version of that array.
; https://leetcode.com/problems/flatten-deeply-nested-array/description/

(defn flatten-new
  [array]
  "flatten an array"
  (reduce
   (fn [c, r]
     (if
      (sequential? r)
       (concat c (flatten r))
       (conj c r)))
   [] 
   array))