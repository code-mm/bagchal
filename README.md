# BagChal
Bagh-Chal is a strategic, two-player board game that originated in Nepal. The game
is asymmetric in that one player controls four tigers and the other player controls
up to twenty goats. The tigers 'hunt' the goats while the goats attempt to block
the tigers' movements.

The game is played on a 5×5 point grid. Pieces are positioned at the intersection
of the lines and not inside the areas delimited by them. Directions of valid movement
between these points are connected by lines. The game play takes place in two phases.
In the first phase the goats are placed on the board while the tigers are moved.
In the second phase both the goats and the tigers are moved. For the tigers,
the objective is to "capture" five goats to win. Capturing is performed, by jumping
over the goats, although capturing is not obligatory. The goats win by blocking all
the tigers' legal moves.

# Compiling
javac -cp src/ src/bagchal/main/Main.java

# Running
java -cp src/ bagchal.main.Main

