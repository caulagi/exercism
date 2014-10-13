module DNA (hammingDistance) where

hammingDistance :: String -> String -> Int
hammingDistance dna1 dna2 = sum $ zipWith (\x y -> if x /= y then 1 else 0) dna1 dna2
