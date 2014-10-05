module Bob ( responseFor ) where
import Data.Char

isQuestion :: String -> Bool
isQuestion que = last que == '?'

isShouting :: String -> Bool
isShouting str = any isAlpha str && not (any isLower str)

isSilence :: String -> Bool
isSilence = all isSpace

responseFor :: String -> String
responseFor x
    | isSilence x = "Fine. Be that way!"
    | isShouting x = "Woah, chill out!"
    | isQuestion x = "Sure."
    | otherwise = "Whatever."
