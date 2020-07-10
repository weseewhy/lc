/*
https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

Given two binary trees original and cloned and given a reference to a node target in the original tree.
The cloned tree is a copy of the original tree. Return a reference to the same node in the cloned tree.
Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

Follow up: Solve the problem if repeated values on the tree are allowed.
*/

import java.util.Stack;

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return helper(original, cloned, target);
    }

    private TreeNode helper(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) {
            return null;
        } else if (original == target) {
            return cloned;
        }

        TreeNode clonedTarget = helper(original.left, cloned.left, target);
        if (clonedTarget == null) {
            clonedTarget = helper(original.right, cloned.right, target);
        }

        return clonedTarget;
    }

    private TreeNode helper_iterative(TreeNode original, TreeNode cloned, TreeNode target) {
        Stack<TreeNode> originalStack = new Stack<>();
        Stack<TreeNode> clonedStack = new Stack<>();

        while (original != null || !originalStack.isEmpty()) {
            while (original != null) {
                originalStack.push(original);
                clonedStack.push(cloned);
                original = original.left;
                cloned = cloned.left;
            }

            original = originalStack.pop();
            cloned = clonedStack.pop();
            if (original == target) {
                return cloned;
            }
            original = original.right;
            cloned = cloned.right;
        }

        return null;
    }
}
