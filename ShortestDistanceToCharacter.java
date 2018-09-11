/*
https://leetcode.com/problems/shortest-distance-to-a-character/

Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:
Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
*/
public class ShortestDistanceToCharacter {

    public int[] shortestToChar(String s, char c) {
        int[] out = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            out[i] = Integer.MAX_VALUE;
        }

        int prevIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                out[i] = 0;
                prevIndex = i;
            } else if (prevIndex != -1) {
                out[i] = i - prevIndex;
            }
        }

        prevIndex = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prevIndex = i;
            } else if (prevIndex != -1) {
                out[i] = Math.min(prevIndex - i, out[i]);
            }
        }

        return out;
    }
}
