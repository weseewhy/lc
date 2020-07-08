/*
https://leetcode.com/problems/path-crossing/

Given a string path, where path[i] = 'N', 'S', 'E' or 'W', 
each representing moving one unit north, south, east, or west, respectively. 
You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

Return True if the path crosses itself at any point, that is, 
if at any time you are on a location you've previously visited. Return False otherwise.

Example 1:
Input: path = "NES"
Output: false 

Example 2:
Input: path = "NESWW"
Output: true

Constraints:
    . 1 <= path.length <= 10^4
    . path will only consist of characters in {'N', 'S', 'E', 'W}
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int x = 0, y = 0;
        set.add(hash(x, y));
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'E' : x++; break;
                case 'W' : x--; break;
                case 'N' : y++; break;
                case 'S' : y--; break;
            }
            String point = hash(x, y);
            if (set.contains(point)) {
                return true;
            }
            set.add(point);
        }
        return false;
    }

    private String hash(int x, int y) {
        return String.format("%d,%d", x, y);
    }
}
