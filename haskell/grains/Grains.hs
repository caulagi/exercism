module Grains (square, total) where

total :: Integer
total = 2 ^ (64 :: Int) - 1

square :: Integer -> Integer
square n = 2 ^ (n-1)
