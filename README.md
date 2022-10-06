This is a backend part of the program that allows 2 human players to play chess remotely. When it is run, the program sets up the board; 
after that players can start moving their pieces. <br><br>
Here is what the program can do:
- it makes sure the moves are made in turn (white - black - white - black) and that the first move is done by the whites
- it makes sure that pieces move according to the rules set for each kind of piece (incl all peculiarities of a pawn - possibility to move across 2 fields 
at the very first move, different ways of moving and capturing, ban on moving backwards)
- it makes sure that pieces don't jump over other pieces (this doesn't apply to knights, of course)
- it blocks the move if destination field is occupied by a piece of the same colour
- it blocks the move if it leads to capturing a king
- if the move leads to capture of enemy piece, such capture is performed and the captured piece is removed from the board
- if, as a result of the move, enemy king gets in check, a warning is issued
- if, as a result of your move, your own king gets in check, this move is cancelled
- if your own king is already in check, you are only allowed to perform a move that removes this check (either move your king from the "line of fire", or put another piece 
between enemy's attacking piece and your king, or capture enemy's attacking piece). Any move that doesn't remove the check is blocked (the program allows you to make it, but 
cancels it immediately).<br><br>

The program doesn't know how to perform castling, doesn't promote a pawn that has reached the last rank into another piece, and 
doesn't allow for capturing enemy pawns en passant.<br>
Also it doesn't declare a checkmate situation as this is left to the players themselves.<br><br>

Moves are mage in the main method of Test class, for example:<br>
Board.blackPawn06.move("f6");<br>
(this command attempts to move the piece with the name "blackPawn06" from it's current position to field f6). <br>
The whole list of pieces with their names can be found in the Board class.<br>
Piece's current position on the board can be printed in the console ( System.out.println(Board.blackKing); ).



