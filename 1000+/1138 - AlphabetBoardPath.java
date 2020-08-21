/*
https://leetcode.com/problems/alphabet-board-path/

On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
  a  b  c  d  e
  f  g  h  i  j
  k  l  m  n  o
  p  q  r  s  t
  u  v  w  x  y
  z

We may make the following moves:
    'U' moves our position up one row, if the position exists on the board;
    'D' moves our position down one row, if the position exists on the board;
    'L' moves our position left one column, if the position exists on the board;
    'R' moves our position right one column, if the position exists on the board;
    '!' adds the character board[r][c] at our current position (r, c) to the answer.
(Here, the only positions that exist on the board are positions with letters on them.)

Return a sequence of moves that makes our answer equal to target in the minimum number of moves. 
You may return any path that does so.

Example 1:
Input: target = "leet"
Output: "DDR!UURRR!!DDD!"

Example 2:
Input: target = "code"
Output: "RR!DDRR!UUL!R!"

Constraints:
    1 <= target.length <= 100
    target consists only of English lowercase letters.
*/

class Solution {
    public String alphabetBoardPath(String target) {
        int[] src = new int[]{0, 0};
        int[] dest;
        StringBuilder sb = new StringBuilder();
        for (char c : target.toCharArray()) {
            dest = getPos(c);
            move(src[0], src[1], dest[0], dest[1], sb);
            src = dest;
        }
        return sb.toString();
    }

    private int[] getPos(char c) {
        int index = c - 'a';
        return new int[]{index / 5, index % 5};
    }

    private void move(int srcRow, int srcCol, int targetRow, int targetCol, StringBuilder path) {
        int dist;
        if (targetCol < srcCol) {
            dist = srcCol - targetCol;
            while (dist-- > 0) {
                path.append('L');
            }
        }

        if (targetRow < srcRow) {
            dist = srcRow - targetRow;
            while (dist-- > 0) {
                path.append('U');
            }
        }

        if (targetRow > srcRow) {
            dist = targetRow - srcRow;
            while (dist-- > 0) {
                path.append('D');
            }
        }

        if (targetCol > srcCol) {
            dist = targetCol - srcCol;
            while (dist-- > 0) {
                path.append('R');
            }
        }

        path.append('!');
    }
}
