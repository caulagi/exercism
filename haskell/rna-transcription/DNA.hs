module DNA ( toRNA ) where

transcribe :: Char -> Char
transcribe c = case c of 
    'C' -> 'G'
    'G' -> 'C'
    'A' -> 'U'
    'T' -> 'A'
    otherwise -> error "What are you doing?"

toRNA :: String -> String
toRNA [] = []
toRNA dna = map transcribe dna
