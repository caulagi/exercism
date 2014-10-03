module DNA ( toRNA ) where

transcribe :: Char -> Char
transcribe c
    | c == 'C' = 'G'
    | c == 'G' = 'C'
    | c == 'A' = 'U'
    | c == 'T' = 'A'
    | otherwise = error "What are you doing?"

toRNA :: String -> String
toRNA [] = []
toRNA (x:xs) = transcribe x : toRNA xs
