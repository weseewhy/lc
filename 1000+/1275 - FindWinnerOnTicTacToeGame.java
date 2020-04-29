/*
https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
Given an array moves where each element is another array of size 2 corresponding to the row and column 
of the grid where they mark their respective character in the order in which A and B play.

Return the winner of the game if it exists (A or B), in case the game ends in a draw 
return "Draw", if there are still movements to play return "Pending".

Example 1:
Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: "A" wins, he always plays first.
"X  "    "X  "    "X  "    "X  "    "X  "
"   " -> "   " -> " X " -> " X " -> " X "
"   "    "O  "    "O  "    "OO "    "OOX"

Example 2:
Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: "B" wins.
"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
"   " -> " O " -> " O " -> " O " -> "XO " -> "XO " 
"   "    "   "    "   "    "   "    "   "    "O  "

Example 3:
Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.
"XXO"
"OOX"
"XOX"

Example 4:
Input: moves = [[0,0],[1,1]]
Output: "Pending"
Explanation: The game has not finished yet.
"X  "
" O "
"   "
*/

class Solution {
    public String tictactoe(int[][] moves) {
        if (moves.length < 5) {
            return "Pending";
        }

        int[][] board = new int[3][3];
        int player = 1;
        for (int i = 0; i < moves.length; i++) {
            int[] pos = moves[i];
            board[pos[0]][pos[1]] = player;

            if (i >= 4 && isDone(board, pos, player)) {
                return player == 1 ? "A" : "B";
            }
            player = player == 1 ? 2 : 1;
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    private boolean isDone(int[][] board, int[] pos, int player) {
        int row = pos[0];
        int col = pos[1];

        // horizantal
        if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
            return true;
        }

        // vertical
        if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
            return true;
        }

        // diagonals
        if (row == col || row + col == 2) {
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                return true;
            }

            if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                return true;
            }
        }

        return false;
    }
}
