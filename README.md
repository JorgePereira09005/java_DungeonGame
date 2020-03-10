# java_DungeonGame
Dungeon game implemented in Java.

This exercise is part of the online "Object-Oriented programming with Java" course from the University of Helsinki.
From the course page:

"In this exercise, you implement a dungeon game. In the game, the player is in a dungeon full of vampires. The player has to destroy the vampires before his lamp runs out of battery and the vampires can suck his blood in the darkness. The player can see the vampires with a blinking of their lamp, after which they have to move blind before the following blinking. With one move, the player can walk as many steps as they want.

The game situation, i.e. the dungeon, the player and the vampires are shown in text form. The first line in the print output tells how many moves the player has left (that is to say, how much battery the lamp has). After that, the print output shows player and vampire positions, which in turn are followed by the game map. In the example below, you see the player (@) and three vampires (v); in this case, the player has enough light for fourteen moves.
The user can move by giving a sequence of commands and pressing Enter. The commands are:

    w go up
    s go down
    a go left
    d go right

When the user commands are executed (the user can give many commands at once), a new game situation is drawn. If the lamp charge reaches 0, the game ends and the text YOU LOSE is printed on the board.

The vampires move randomly in the game, and they take one step for each step the player takes. If the player and a vampire run into each other (even momentarily) the vampire is destroyed. If a vampire tries to step outside the board, or into a place already occupied by another vampire, the move is not executed. When all the vampires are destroyed, the game ends and it prints YOU WIN."
