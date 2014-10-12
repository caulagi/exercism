module SumOfMultiples (
  sumOfMultiples
, sumOfMultiplesDefault
) where

sumOfMultiples :: [Int] -> Int -> Int
sumOfMultiples xs n = sum (filter (\a -> any (\x -> a `mod` x == 0) xs) [1..n-1])

sumOfMultiplesDefault :: Int -> Int
sumOfMultiplesDefault = sumOfMultiples [3,5]
