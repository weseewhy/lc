/*
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
You can use each character in text at most once. Return the maximum number of instances that can be formed.

Example 1:
Input: text = "nlaebolko"
Output: 1

Example 2:
Input: text = "loonbalxballpoon"
Output: 2

Example 3:
Input: text = "leetcode"
Output: 0

Constraints:
  - 1 <= text.length <= 10^4
  - Text consists of lower case English letters only.
*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[5];

        for (char c : text.toCharArray()) {
            if (c == 'b') cnt[0]++;
            else if (c == 'a') cnt[1]++;
            else if (c == 'l') cnt[2]++;
            else if (c == 'o') cnt[3]++;
            else if (c == 'n') cnt[4]++;
        }

        cnt[2] /= 2;
        cnt[3] /= 2;

        int min = Integer.MAX_VALUE;
        for (int i : cnt) {
            min = Math.min(min, i);
        }

        return min;
    }
}
