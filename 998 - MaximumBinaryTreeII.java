/*
https://leetcode.com/problems/maximum-binary-tree-ii/

We are given the root node of a maximum tree: a tree where every node
has a value greater than any other value in its subtree.

The given tree was constructed from an list A (root = Construct(A)) recursively
with the following Construct(A) routine:
  - If A is empty, return null.
  - Otherwise, let A[i] be the largest element of A.  Create a root node with value A[i].
  - The left child of root will be Construct([A[0], A[1], ..., A[i-1]])
  - The right child of root will be Construct([A[i+1], A[i+2], ..., A[A.length - 1]])
  - Return root.
Note that we were not given A directly, only a root node root = Construct(A).

Suppose B is a copy of A with the value val appended to it.
It is guaranteed that B has unique values.
Return Construct(B).

Example 1:
Input: root = [4,1,3,null,null,2], val = 5
      4            5
    /  \          /
   1    3        4
       /        /  \
      2        1    3
                   /
                  2
Output: [5,4,null,1,3,null,null,2]
Explanation: A = [1,4,2,3], B = [1,4,2,3,5]

Example 2:
Input: root = [5,2,4,null,1], val = 3
      5          5
    /  \       /  \
   2    4     2    4
    \         \     \
     1        1      3
Output: [5,2,4,null,1,null,3]
Explanation: A = [2,1,5,4], B = [2,1,5,4,3]

Example 3:
Input: root = [5,2,3,null,1], val = 4
      5          5
    /  \       /  \
   2    3     2    4
    \         \    /
     1        1   3
Output: [5,2,4,null,1,3]
Explanation: A = [2,1,5,3], B = [2,1,5,3,4]
*/

class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode valNode = new TreeNode(val);
        if (root == null || root.val < val) {
            valNode.left = root;
            return valNode;
        }

        TreeNode valNodeParent = root;
        while (valNodeParent.right != null && valNodeParent.right.val > val) {
            valNodeParent = valNodeParent.right;
        }

        valNode.left = valNodeParent.right;
        valNodeParent.right = valNode;
        return root;
    }
}