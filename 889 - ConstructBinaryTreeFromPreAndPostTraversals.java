/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

Return any binary tree that matches the given preorder and postorder traversals.
Values in the traversals pre and post are distinct positive integers.

Example 1:
Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]

*/

class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return construct(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode construct(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) {
            return root;
        }

        /*
        pre  = [1,2,4,5,3,6,7]
                  ^
        post = [4,5,2,6,7,3,1]
                    ^
        First char for left subtree in prefix will be last char in postfix. eg: 2 in above
        Find the length and recurse
        */
        int len = 0;
        for (int i = postStart; i < postEnd; i++) {
            len++;
            if (post[i] == pre[preStart + 1]) break;
        }

        root.left = construct(pre, preStart + 1, preStart + len, post, postStart, postStart + len - 1);
        root.right = construct(pre, preStart + len + 1, preEnd, post, postStart + len, postEnd - 1);
        return root;
    }

}
