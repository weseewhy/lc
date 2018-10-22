/*
https://leetcode.com/problems/long-pressed-name/

Your friend is typing his name into a keyboard.  Sometimes, when typing a character c,
the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.
Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

Example 1:
Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.

Example 2:
Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.

Example 3:
Input: name = "leelee", typed = "lleeelee"
Output: true

Example 4:
Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.
*/

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < name.length() && j < typed.length()) {
            char c1 = name.charAt(i);
            char c2 = typed.charAt(j);
            if (c1 != c2) {
                return false;
            }

            i++;
            int cnt1 = 1;
            while (i < name.length() && name.charAt(i) == c1) {
                cnt1++;
                i++;
            }

            j++;
            int cnt2 = 1;
            while (j < typed.length() && typed.charAt(j) == c2) {
                cnt2++;
                j++;
            }

            if (cnt1 > cnt2) {
                return false;
            }
        }

        return i == name.length() && j == typed.length();
    }
}
