import java.util.Scanner;

class Checkers {
    private static final int SIZE = 8;
    private static final char EMPTY = '.';
    private static final char RED = 'R';
    
    private static final char BLACK = 'B';
    private char[][] board = new char[SIZE][SIZE];
    
    public Checkers() {
        initializeBoard();
    }
    
    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((i + j) % 2 == 1) {
                    if (i < 3) board[i][j] = BLACK;
                    else if (i > 4) board[i][j] = RED;
                    else board[i][j] = EMPTY;
                } else {
                    board[i][j] = EMPTY;
                }
            }
        }
    }
    
    public void displayBoard() {
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public boolean movePiece(int x1, int y1, int x2, int y2) {
        if (isValidMove(x1, y1, x2, y2)) {
            board[x2][y2] = board[x1][y1];
            board[x1][y1] = EMPTY;
            return true;
        }
        return false;
    }
    
    private boolean isValidMove(int x1, int y1, int x2, int y2) {
        if (x2 < 0 || x2 >= SIZE || y2 < 0 || y2 >= SIZE || board[x1][y1] == EMPTY) return false;
        char piece = board[x1][y1];
        
        
        if (Math.abs(x2 - x1) == 1 && Math.abs(y2 - y1) == 1 && board[x2][y2] == EMPTY) {
            return true; 
        } 
        
        if (Math.abs(x2 - x1) == 2 && Math.abs(y2 - y1) == 2) {
            int midX = (x1 + x2) / 2;
            int midY = (y1 + y2) / 2;
            if (board[midX][midY] != EMPTY && board[midX][midY] != piece) {
                board[midX][midY] = EMPTY; 
                return true;
            }
        }
        return false;
    }

    private boolean canMove(int x, int y) {
        char piece = board[x][y];
        int direction = (piece == RED) ? -1 : 1;
    
        if (isValidMove(x, y, x + direction, y - 1) || isValidMove(x, y, x + direction, y + 1)) {
            return true;
        }
        if (isValidMove(x, y, x + 2 * direction, y - 2) || isValidMove(x, y, x + 2 * direction, y + 2)) {
            return true;
        }
        return false;
    }
    
    private boolean hasValidMoves(char player) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == player) {
                    if (canMove(i, j)) return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Checkers game = new Checkers();
        Scanner scanner = new Scanner(System.in);
        boolean redTurn = true;
        
        while (true) {
            game.displayBoard();
            if (!game.hasValidMoves(RED)) {
                System.out.println("Black wins!");
                break;
            } else if (!game.hasValidMoves(BLACK)) {
                System.out.println("Red wins!");
                break;
            }
            System.out.println((redTurn ? "Red" : "Black") + "'s turn.");
            System.out.print("Enter move (x1 y1 x2 y2): ");
            int x1 = scanner.nextInt(), y1 = scanner.nextInt(), x2 = scanner.nextInt(), y2 = scanner.nextInt();
            
            if (game.movePiece(x1, y1, x2, y2)) {
                redTurn = !redTurn;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }
} 