/*
https://leetcode.com/problems/single-element-in-a-sorted-array/

Given a sorted array consisting of only integers where every element appears twice except for one element which appears once.
Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10

Note: Your solution should run in O(log n) time and O(1) space.
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if ((mid - start) % 2 == 0) { // even elements in each half
                if (nums[mid] == nums[mid - 1]) {          // case: 1-a
                    end = mid - 2;
                } else if (nums[mid] == nums[mid + 1]) {   // case: 1-b
                    start = start + 2;
                } else {
                    return nums[mid];
                }
            } else { // Odd elements in each half
                if (nums[mid] == nums[mid + 1]) {         // case: 1-a
                    end = mid - 1;
                } else if (nums[mid] == nums[mid - 1]) {  // case: 1-b
                    start = mid + 1;
                } else {
                    return nums[mid];
                }
            }
        }

        return nums[start];
    }
}

/*
Possible cases:

1) Even elements in each half
   a) 1 1 2 3 [3] 4 4 8 8  --> single in left
   b) 1 1 2 2 [3] 3 4 8 8  --> single in right

2) Odd elements in each half
   a) 1 1 2 [3] 3 4 4  --> single in left
   b) 1 1 2 [2] 3 4 4  --> single in right
*/
