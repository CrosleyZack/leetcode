(ns leetcode.longest-subsequence
  (:require [clojure.math.combinatorics :as combo]))

; Given an integer array nums, return the length of
;   the longest strictly increasing subsequence.
;
; https://leetcode.com/problems/longest-increasing-subsequence

(defn longest-subsequence-rear
  "gets longest increasing subsequence of an array"
  [array]
  (if
   (= (count array) 1)
   1
   (if
    ; If first two elements are ordered
    (< (get array 0) (get array 1))
    (apply max
     ; Get maximum seq length
     (map 
      #(+ (longest-subsequence-rear (drop % array)) 1)
     (range 1 (- (count array) 1)))
  ))))

(defn longest-subsequence-front
 [array]
 (apply max
  (map
   #(longest-subsequence-rear (take % array))
   (range 1 (count array)))))

(longest-subsequence-front [1 2 3 4 3 2 1])