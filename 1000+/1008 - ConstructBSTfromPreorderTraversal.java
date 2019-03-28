/*
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

Return the root node of a binary search tree that matches the given preorder traversal.

Example 1:
Input: [8,5,1,7,10,12]
         8
       /   \
      5     10
    /  \      \
   1    7      12
Output: [8,5,10,1,7,null,12]
*/

class Solution {
    public TreeNode bstFromPreorder(int[] arr) {
        return bst(arr, 0, arr.length - 1);
    }

    private TreeNode bst(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(arr[start]);
        int nextStart = start + 1;
        if (nextStart <= end && arr[nextStart] < root.val) {
            int nextEnd = nextStart;
            while (nextEnd + 1 <= end && arr[nextEnd + 1] < root.val) {
                nextEnd++;
            }

            root.left = bst(arr, nextStart, nextEnd);
            nextStart = nextEnd + 1;
        }

        if (nextStart <= end) {
            root.right = bst(arr, nextStart, end);
        }

        return root;
    }
}
