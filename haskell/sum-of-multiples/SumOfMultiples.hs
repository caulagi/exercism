module SumOfMultiples (
  sumOfMultiples
, sumOfMultiplesDefault
) where

import Data.List (nub)

multiplesOf :: (Int, Int) -> [Int]
multiplesOf (n, end) = [x | x <- [1..end-1], x `mod` n == 0]

sumOfMultiples :: [Int] -> Int -> Int
sumOfMultiples a n = sum (nub (concatMap multiplesOf (zip a (replicate (length a) n))))

sumOfMultiplesDefault :: Int -> Int
sumOfMultiplesDefault = sumOfMultiples [3,5]
