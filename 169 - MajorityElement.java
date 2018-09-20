/*
https://leetcode.com/problems/majority-element

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
Input: [3,2,3]
Output: 3

Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2
*/

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int elem = nums[0];
        int cnt = 0;

        for (int i : nums) {
            if (cnt == 0) {
                elem = i;
                cnt = 1;
            } else if (elem == i) {
                cnt ++;
            } else {
                cnt--;
            }
        }

        return elem;
    }
}
