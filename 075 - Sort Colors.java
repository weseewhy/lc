/*
https://leetcode.com/problems/sort-colors/description/

Given an array with n objects colored red, white or blue, sort them in-place
so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Example:
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with a one-pass algorithm using only constant space?
*/

class Solution {
    /* Dutch national flag problem
       0 0 0 0 1 1 1 x x x x x x x x 2 2 2 2
               ^     ^             ^
              low   cur
     */

    public void sort012s(int[] a) {
        int low = 0;                // points to next insert position for 0
        int cur = 0;                // Points to first unprocessed number / next insert position for 1
        int high = a.length - 1;    // Points to last unprocessed number / next insert position for 2

        while (cur <= high) {
            if (a[cur] == 0) {
                swap(a, low, cur);
                low++;
                cur++;
            } else if (a[cur] == 2) {
                swap(a, cur, high);
                high--;
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        if (i != j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
