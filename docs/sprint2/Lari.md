Tasks
=====
- Create a class to read files with a pre-loaded map and generate the map
structure to be used in the game.

Discussion
==========
We decided to do first the loading and creation of the map, before we create the
map structure and the map elements. So in this task i am focusing to read a file
and analyze each caractere of it, and this way in the future we can include real
symbols, substitute the simple array by a real map and use its methods to add
elements to it.

Design
------
I decided to use Singleton design pattern, because we won't have to manipulate
FileMapReader objects, we only have to use its static functions to read
specified file passed as a parameter and return created map.

FileMapReader exports just one static method, that is:
- readFile(String path):
  - Where you have to pass the path to the file.
  - It return a char array with two dimmensions.
    (In the future will be a map structure)

The map file must have the two first line to inform the dimension of the map.
The first line is the number of lines and the second is the number of columns.
The next lines represent all the lines expected for the map. See next example:

5
10
--w--h---v
-wk--h-v-m
-syh---sdk
--weikh--v
--wdj--h--

For now, these symbols don't represent anything, because we haven't discussed
yet what our map will support. Maybe in the future each map element will have a
letter to represent it (example: "m" for a monster).

Implementation
--------------
FileMapReader use FileReader classe to read a file, and BufferedReader to get
each line from it. This way we process each line, getting each caracter from it,
and interpreting the caracter to generate a map element.

Next Steps
==========
Next steps probably are to create a map structure and use it to generate a map
from the file. We also have to choose symbols to be used in the txt file to
represent each element, and then add this particular element in map structure
in the same position as in the file.
