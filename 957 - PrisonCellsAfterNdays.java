/*
https://leetcode.com/problems/prison-cells-after-n-days/

There are 8 prison cells in a row, and each cell is either occupied or vacant.
Each day, whether the cell is occupied or vacant changes according to the following rules:
If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant. The first and the last cells in the row can't have two adjacent neighbors.
cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
Given the initial state of the prison, return the state of the prison after N days

Example 1:
Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: 
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Example 2:
Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> lastSeenAt = new HashMap<>();
        while (n > 0) {
            lastSeenAt.put(Arrays.toString(cells), n);
            n--;

            int[] newState = new int[8];
            for (int i = 1; i <= 6; i++) {
                newState[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }

            String newStateStr = Arrays.toString(newState);
            if (lastSeenAt.containsKey(newStateStr)) {
                n %= (lastSeenAt.get(newStateStr) - n); // the pattern repeated. So skip the cycles
            }

            cells = newState;
        }

        return cells;
    }
}
