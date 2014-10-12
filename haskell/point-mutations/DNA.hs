module DNA (hammingDistance) where

hammingDistance :: String -> String -> Int
hammingDistance dna1 dna2 = sum [1 | (x, y) <- zip dna1 dna2, x /= y]
