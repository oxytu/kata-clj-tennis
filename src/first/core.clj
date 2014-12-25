(ns first.core)

(defstruct game
  :points-one
  :points-two)

(defn next-higher [old-point]
  (condp = old-point
    :love :fifteen
    :fifteen :thirty
    :thirty :fourty
    :fourty :advantage))

(defn next-lower [old-point]
  (condp = old-point
    :advantage :fourty
    :fourty :thirty
    :thirty :fifteen
    :fifteen :love))

(defn create-game 
  ([]
    (struct game :love :love))
  ([initial-one initial-two]
    (struct game initial-one initial-two)))

(defn player-one-wins [old-game]
  (create-game (next-higher (:points-one old-game)) (:points-two old-game)))

(defn player-two-wins [old-game]
  (create-game (:points-one old-game) (next-higher (:points-two old-game))))