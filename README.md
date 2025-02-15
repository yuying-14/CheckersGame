Checkers Game
A simple console-based Checkers game implemented in Java. The game allows two players to take turns moving pieces on an 8x8 board, with the goal of capturing all of the opponent's pieces or blocking them so they can't move.

How to Play
1. Start the game: The game starts by displaying the initial board setup.
2. Player turns: Players take turns to move their pieces.
- To move a piece, input the coordinates of the starting square and the destination square in the format x1 y1 x2 y2.
- For example, to move a piece from row 5, column 0 to row 4, column 1, enter 5 0 4 1.
3. Capturing pieces: If a player lands on an opponent's piece and there is an empty space immediately after it in the same diagonal, the opponent's piece is captured.
4. Game end: The game ends when a player has no valid moves left. The other player wins.