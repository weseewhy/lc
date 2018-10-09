/*
https://leetcode.com/problems/maximum-binary-tree/

Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
*/

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        int indexForMax = findIndexForMaxNum(nums, left, right);
        TreeNode root = new TreeNode(nums[indexForMax]);
        if (indexForMax > left) {
            root.left = constructMaximumBinaryTree(nums, left, indexForMax - 1);
        }

        if (indexForMax < right) {
            root.right = constructMaximumBinaryTree(nums, indexForMax + 1, right);
        }

        return root;
    }

    private int findIndexForMaxNum(int[] nums, int start, int end) {
        int indexForMax = start;
        int max = nums[start];
        start++;

        while (start <= end) {
            if (nums[start] > max) {
                indexForMax = start;
                max = nums[start];
            }
            start++;
        }

        return indexForMax;
    }
}
