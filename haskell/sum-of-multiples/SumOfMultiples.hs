module SumOfMultiples (
  sumOfMultiples
, sumOfMultiplesDefault
) where

-- whether n is a multiple of any number in a
multipleOf :: [Int] -> Int -> Bool
multipleOf [] n = False
multipleOf (x:xs) n = n `mod` x == 0 || multipleOf xs n

sumOfMultiples :: [Int] -> Int -> Int
sumOfMultiples a n = sum (filter (multipleOf a) [1..n-1])

sumOfMultiplesDefault :: Int -> Int
sumOfMultiplesDefault = sumOfMultiples [3,5]
