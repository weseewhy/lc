/*
https://leetcode.com/problems/word-search/

Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        } else if (board.length == 0 || board.length * board[0].length < word.length()) {
            return false;
        }

        Set<Integer> used = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (dfs(board, row, col, word, 0, used)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int index, Set<Integer> used) {
        int bIndex = row * board[0].length + col;
        if (index == word.length()) {
            return true;
        } else if (!withinBounds(board, row, col) || board[row][col] != word.charAt(index) || used.contains(bIndex)) {
            return false;
        }

        used.add(bIndex);
        boolean found = dfs(board, row, col - 1, word, index + 1, used) ||
                dfs(board, row, col + 1, word, index + 1, used) ||
                dfs(board, row - 1, col, word, index + 1, used) ||
                dfs(board, row + 1, col, word, index + 1, used);
        used.remove(bIndex);
        return found;
    }

    private boolean withinBounds(char[][] board, int row, int col) {
        return row >= 0 && row < board.length &&
                col >= 0 && col < board[0].length;
    }
}
