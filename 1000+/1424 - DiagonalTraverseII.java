/*
https://leetcode.com/problems/diagonal-traverse-ii/

Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.

Example 1:
Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]

Example 2:
Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]

Example 3:
Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
Output: [1,4,2,5,3,8,6,9,7,10,11]

Example 4:
Input: nums = [[1,2,3,4,5,6]]
Output: [1,2,3,4,5,6]

Constraints:
    . 1 <= nums.length <= 10^5
    . 1 <= nums[i].length <= 10^5
    . 1 <= nums[i][j] <= 10^9
    . There at most 10^5 elements in nums.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> out = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            out.add(nums.get(row).get(col));

            // Add bottom element only if it's first column
            if (col == 0 && row + 1 < nums.size()) {
                queue.add(new int[]{row + 1, col});
            }

            // Add right element if it exists
            if (col + 1 < nums.get(row).size()) {
                queue.add(new int[]{row, col + 1});
            }
        }

        return out.stream().mapToInt(i -> i).toArray();
    }
}
