module DNA ( toRNA ) where

transcribe :: Char -> Char
transcribe c = case c of 
    'C' -> 'G'
    'G' -> 'C'
    'A' -> 'U'
    'T' -> 'A'
    otherwise -> error (show c ++ " is not valid DNA")

toRNA :: String -> String
toRNA = map transcribe
