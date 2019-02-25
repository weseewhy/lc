/*
On an 8 x 8 chessboard, there is one white rook.
There also may be empty squares, white bishops, and black pawns.
These are given as characters 'R', '.', 'B', and 'p' respectively.
Uppercase characters represent white pieces, and lowercase characters represent black pieces.

The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south),
then moves in that direction until it chooses to stop, reaches the edge of the board,
or captures an opposite colored pawn by moving to the same square it occupies.
Also, rooks cannot move into the same square as other friendly bishops.

Return the number of pawns the rook can capture in one move.
*/

class Solution {
    public int numRookCaptures(char[][] board) {
        int rookRow = -1;
        int rookCol = -1;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'R') {
                    rookRow = row;
                    rookCol = col;
                    break;
                }
            }
        }

        int cnt = 0;
        for (int row = rookRow + 1; row < board.length; row++) {
            char val = board[row][rookCol];
            if (val == 'B') {
                break;
            } else if (val == 'p') {
                cnt++;
                break;
            }
        }

        for (int row = rookRow - 1; row >= 0; row--) {
            char val = board[row][rookCol];
            if (val == 'B') {
                break;
            } else if (val == 'p') {
                cnt++;
                break;
            }
        }

        for (int col = rookCol + 1; col < board[0].length; col++) {
            char val = board[rookRow][col];
            if (val == 'B') {
                break;
            } else if (val == 'p') {
                cnt++;
                break;
            }
        }

        for (int col = rookCol - 1; col >= 0; col--) {
            char val = board[rookRow][col];
            if (val == 'B') {
                break;
            } else if (val == 'p') {
                cnt++;
                break;
            }
        }

        return cnt;
    }
}
