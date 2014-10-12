module Strain (keep, discard) where

keep :: (a -> Bool) -> [a] -> [a]
keep fn [] = []
keep fn (x:xs) = if fn x then x : keep fn xs else keep fn xs

discard :: (a -> Bool) -> [a] -> [a]
discard fn [] = []
discard fn (x:xs) = if not (fn x) then x : discard fn xs else discard fn xs
