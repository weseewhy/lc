/*
https://leetcode.com/problems/battleships-in-a-board/

Given an 2D board, count how many battleships are in it.
The battleships are represented with 'X's, empty slots are represented with '.'s.

You may assume the following rules:
- You receive a valid board, made of only battleships or empty slots.
- Battleships can only be placed horizontally or vertically.
- At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.

Example:
X..X
...X
...X
In the above board there are 2 battleships.

Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always have a cell separating between them.

Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
*/

class Solution {
    public int countBattleships(char[][] board) {
        int cnt = 0;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == 'X') {
                    if (x == 0 && y == 0) {
                        cnt++;
                    } else if (x == 0) {
                        if (board[0][y - 1] == '.') {
                            cnt++;
                        }
                    } else if (y == 0) {
                        if (board[x - 1][0] == '.') {
                            cnt++;
                        }
                    } else if (board[x - 1][y] == '.' && board[x][y - 1] == '.') {
                        cnt++;
                    }

                }
            }
        }

        return cnt;
    }
}
