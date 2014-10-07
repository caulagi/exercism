module Sublist (Sublist(..), sublist) where

data Sublist = Equal | Unequal | Sublist | Superlist deriving (Show, Eq)

isEquallist :: (Eq a) => [a] -> [a] -> Bool
isEquallist [] [] = True
isEquallist [] a = False
isEquallist a [] = False
isEquallist a1 a2
    | head a1 == head a2  = isEquallist (tail a1) (tail a2)
    | otherwise = False

isSublist :: (Eq a) => [a] -> [a] -> Bool
isSublist [] [] = True
isSublist [] a = True
isSublist a [] = False
isSublist a1 a2
    | x1 == x2 && isEquallist xs1 (take (length xs1) xs2) = True
    | otherwise = isSublist a1 xs2
    where x1 = head a1
          xs1 = tail a1
          x2 = head a2
          xs2 = tail a2

sublist :: (Eq a) => [a] -> [a] -> Sublist
sublist [] [] = Equal
sublist [] a = Sublist
sublist a [] = Superlist
sublist a1 a2
    | length a1 < length a2 && isSublist a1 a2 = Sublist
    | length a1 < length a2 = Unequal
    | length a1 > length a2 && isSublist a2 a1 = Superlist
    | length a1 > length a2 = Unequal
    | isEquallist a1 a2 = Equal
    | otherwise = Unequal
