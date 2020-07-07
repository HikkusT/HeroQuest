Tasks
=====
- Create a class to take care of all managment of dices in the game

Discussion
==========

Design
------
We decided to use Singleton design pattern, because this way we can isolate
the dice manager from the rest of the code, and the dice can be used for anyone
anywhere. Dice manager exports three static methods:

- move
  - With no parameters, because everyone needs to roll two dices.
  - Two red dices are rolled and the sum is returned.
- attack
  - Receive the number of dices that need to be rolled.
  - Return the sum of dices that got skull side of dice.
- defendHero
  - Receive the number of dices that need to be rolled.
  - Return the sum of dices that got hero shield side of dice.
- defendMonster
  - Receive the number of dices that need to be rolled.
  - Return the sum of dices that got monster shield side of dice.


Implementation
--------------
Dice manager has a static attribute that is the dice. The same dice is used
everytime we roll a dice, and the dice operate with two methods:

- rollRedDice:
  - Return and arbitrary number from 1 to 6.
- rollCombatDice:
  - Return skull with probability of 1/2.
  - Return hero shield with probability of 1/3.
  - Return monster shield with probability of 1/6.

To work with the combat dice, that returns constants that represent the sides of
the dice, has been created the DiceSides enum, with the constants:
- SKULL
- HEROSHIELD
- MONSTERSHIELD

Next Steps
==========
Dice manager can be easily used when any entity needs to move, attack or defend
itself. This part of code is isolated and is fully implemented already, so
hopefully we will not have to change it. But maybe in the future we will have
more features that will use dices to get an arbitrary value, and we will have to
add new methods or discuss another sctructure that could be better for dice
manager.
