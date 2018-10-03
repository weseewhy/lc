/*
https://leetcode.com/problems/average-of-levels-in-binary-tree/

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]

Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> out = new ArrayList<>();
        if (root == null) {
            return out;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        list.add(null);

        double sum = 0;
        int curLevelCount = 1;
        int nextLevelCount = 0;

        while (!list.isEmpty()) {
            TreeNode node = list.remove();
            if (node == null) {
                out.add(sum / curLevelCount);
                sum = 0;
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;

                if (!list.isEmpty()) {
                    list.add(null);
                }
            } else {
                sum += node.val;

                if (node.left != null) {
                    list.add(node.left);
                    nextLevelCount++;
                }
                if (node.right != null) {
                    list.add(node.right);
                    nextLevelCount++;
                }
            }
        }

        return out;
    }
}
