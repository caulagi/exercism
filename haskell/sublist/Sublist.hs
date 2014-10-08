module Sublist (Sublist(..), sublist) where

data Sublist = Equal | Unequal | Sublist | Superlist deriving (Show, Eq)

isEquallist :: (Eq a) => [a] -> [a] -> Bool
isEquallist [] [] = True
isEquallist [] a = False
isEquallist a [] = False
isEquallist (x1:xs1) (y1:ys1)
    | x1 == y1  = isEquallist xs1 ys1
    | otherwise = False

isSublist :: (Eq a) => [a] -> [a] -> Bool
isSublist [] [] = True
isSublist [] a = True
isSublist a [] = False
isSublist x@(x1:xs1) (y1:ys1)
    | x1 == y1 && isEquallist xs1 (take (length xs1) ys1) = True
    | otherwise = isSublist x ys1

sublist :: (Eq a) => [a] -> [a] -> Sublist
sublist a1 a2 = case compare (length a1) (length a2) of
    LT -> case isSublist a1 a2 of
            True -> Sublist
            False -> Unequal
    GT -> case isSublist a2 a1 of
            True -> Superlist
            False -> Unequal
    otherwise -> case isEquallist a1 a2 of
            True -> Equal
            False -> Unequal
