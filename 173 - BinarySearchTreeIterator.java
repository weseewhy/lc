/*
Implement an iterator over a binary search tree (BST).
Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.

Example:
         7
       /  \
      3   15
         /  \
        9    20
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
*/

import java.util.Stack;

class BSTIterator {

    private TreeNode cur;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.cur = root;
    }

    public int next() {
        if (!hasNext()) {
            throw new RuntimeException("Not found!");
        }

        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        cur = stack.pop();
        int retVal = cur.val;
        cur = cur.right;
        return retVal;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
