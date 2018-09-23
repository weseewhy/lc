/*
https://leetcode.com/problems/third-maximum-number/

Given a non-empty array of integers, return the third maximum number in this array. 
If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]
Output: 1
Explanation: The third maximum is 1.

Example 2:
Input: [1, 2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:
Input: [2, 2, 3, 1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int distinct = 0;
        int[] max = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i : nums) {
            if ((i == max[0] && distinct > 0) || (i == max[1] && distinct > 1)) {
                continue;
            }

            if (i > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = i;
                distinct++;
            } else if (i > max[1]) {
                max[2] = max[1];
                max[1] = i;
                distinct++;
            } else if (i >= max[2]) {
                max[2] = i;
                distinct++;
            }
        }

        return distinct >= 3 ? max[2] : max[0];
    }
}
