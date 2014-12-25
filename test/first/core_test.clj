(ns first.core-test
  (:require [clojure.test :refer :all]
            [first.core :refer :all]))

(deftest tennis-game
 (testing "New game should have no points"
   (is (= :love (:points-one (create-game))))
   (is (= :love (:points-two (create-game))))))

(deftest the-winner-gets-the-points
 (testing "The winner get's the points!"
   (is (= (create-game :fifteen :love) (player-one-wins (create-game))))
   (is (= (create-game :thirty :love) (player-one-wins (player-one-wins (create-game)))))
   (is (= (create-game :love :fifteen) (player-two-wins (create-game))))
   (is (= (create-game :fifteen :fifteen) (player-two-wins (player-one-wins (create-game)))))
   ))
