(ns leetcode.valid-triangle
  (:require '[clojure.math.combinatorics :as combo]))

; Given an integer array nums, return the number of
;   triplets chosen from the array that can make
;   triangles if we take them as side lengths of a triangle.
;
; https://leetcode.com/problems/valid-triangle-number/

(defn valid-triangle
  "checks if three numbers can make a valid triangle."
  [side1 side2 side3]
  (and
    (< side1 (+ side2 side3))
    (< side2 (+ side1 side3))
    (< side3 (+ side1 side2))))

(defn triangle-num
  "Get how many combinations of values from array make a valid triangle."
  [array]
  (count (filter (fn [triple] (apply valid-triangle triple))
                 (combo/combinations array 3))))

(triangle-num [4 2 3 4])