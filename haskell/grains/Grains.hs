module Grains (square, total) where

totalFor :: Integer -> Integer
totalFor n = sum (map square [1..n])

total :: Integer
total = totalFor 64

powerOf' :: Integer -> Integer -> Integer -> Integer
powerOf' _ 1 acc = acc
powerOf' x n acc = powerOf' x (n - 1) (x * acc)

powerOf :: Integer -> Integer -> Integer
powerOf x n = powerOf' x n 1

square :: Integer -> Integer
square n = powerOf 2 n
