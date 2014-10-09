module Gigasecond (fromDay) where

import Data.Time.Calendar (Day, addDays)

fromDay :: Day -> Day
fromDay n =
  addDays (round ((10 ^ 9)/(60 * 60 * 24))) n
