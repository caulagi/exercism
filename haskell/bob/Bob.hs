module Bob ( responseFor ) where
import Data.Char

isQuestion :: String -> Bool
isQuestion que = last que == '?'

-- Round about way of checking whether we are shouting,
-- because the tests seem messed up?
isShouting :: String -> Bool
isShouting str = (any isAlpha) str && (all isUpper . filter isAlpha) str

isSilence :: String -> Bool
isSilence = all isSpace

responseFor :: String -> String
responseFor x
    | isSilence x = "Fine. Be that way!"
    | isShouting x = "Woah, chill out!"
    | isQuestion x = "Sure."
    | otherwise = "Whatever."
