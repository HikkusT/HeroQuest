# Contributors
This game was developed by:
- [Larissa Escaliante (Lari)](https://github.com/LarIsCoding)
- [Luiz Henrique (Hik)](https://github.com/HikkusT)
- [Rafael Mantovani (Manta)](https://github.com/rafaelmanto)

It was developed as a project for Unicamp's MC322 class.

# Running the game
Unfortunately, we didn't make a build, so you must run it yourself. The game entrypoint is the Runner class. It was developed in Java 8, but it runs fine
with Java 11 aswell. Once it's running you are asked on the terminal which renderer do you wish to use (GUI or Terminal). If you choose GUI, depending on your OS the
spawned window may not be focused so alt tab to it if necessary. In-game commands are:
- Movement: WASD
- Open Door: E
- Search Treasures: 1
- Search Traps: 2
- Disarm Trap: 3
- End Turn: 4
- Attack: Space

# Screenshots
### Graphics interface
![GUI](/docs/GUI.png)

### Random Generation
We kept the original Hero Quest layout and added randomness to the room distribution(how they are "sliced") and doors/treasures/traps placements. Here are two
different generated maps:
![RandomGeneration](/docs/RandomGeneration.png)

### Terminal interface
![Terminal](/docs/Terminal.png)
