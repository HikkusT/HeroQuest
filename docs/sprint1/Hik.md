Tasks
=====
- Start the project
- Structure the project to use a Renderer object

Discussion
==========

Design
------
The first decision I had to make was on how we should organize the information we should render. I split it in three main regions:
- World render
  - Where we should display the world/map
  - Basically the core of the game
  - Think of it as the Scene of a topdown game
- Info render
  - Where we should display the info of the player and maybe expand it to other characters
  - Things like current HP, items, skills, number of movements remaining
  - Think of it as the UI of a game
- Event render
  - Where we should display every impactful event that happens in the world
  - Examples are showing the damage a monster has taken or the reward from opening a chest

With that out of the way, what I had to figure out after was how I should implement the Renderer object. I decided against going with a Singleton pattern because I don't want everyone to have access to the renderer. Game logic should be isolated from render logic. 

I went for a normal object approach that should be instanciated and managed only from our top-most GameManager. I'm not sure how this will work but it's hard to predict.


Implementation
--------------
Finally I implemented a Renderer for the terminal, which is pretty straightforward, and prototyped a Renderer using some java graphical framework. The framework I chose was AWT. After tinkering for a bit I had some trouble with things that I expected from any graphical framework but AWT didn't provide right out-of-the-box. Some search later and I decided to ditch AWT and switch over to Swing.

For now I kept the AWT implementation but it **will** be deprecated.

Next Steps
==========
I'm not entirely sure on how I'm going to trigger the events renders. Lots of classes may need to have access to this type of render and I don't want to pass my Renderer to everyone. 

Also I need to study how to handle input in case we continue with a graphical approach.