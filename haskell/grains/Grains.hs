module Grains (square, total) where

total :: Integer
total = (2 ^ 64) - 1

square :: Integer -> Integer
square n = 2 ^ (n-1)
