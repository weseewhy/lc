/*
https://leetcode.com/problems/all-possible-full-binary-trees/

A full binary tree is a binary tree where each node has exactly 0 or 2 children.
Return a list of all possible full binary trees with N nodes.
Each element of the answer is the root node of one possible tree.
Each node of each tree in the answer must have node.val = 0.

Example:
Input: n = 5
Output:
       0              0
     /  \           /  \
    0    0         0    0
        / \       / \
       0   0     0   0
*/

import java.util.*;

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return Collections.emptyList();
        }

        Map<Integer, List<TreeNode>> map = new HashMap<>();
        map.put(1, Collections.singletonList(new TreeNode(0)));

        return generate(n, map);
    }

    private List<TreeNode> generate(int n, Map<Integer, List<TreeNode>> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        map.put(n, new ArrayList<>());
        for (int leftCnt = 1; leftCnt < n; leftCnt = leftCnt + 2) {
            int rightCnt = n - leftCnt - 1;

            List<TreeNode> possibleLeft = generate(leftCnt, map);
            List<TreeNode> possibleRight = generate(rightCnt, map);

            for (TreeNode left : possibleLeft) {
                for (TreeNode right : possibleRight) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    map.get(n).add(root);
                }
            }
        }

        return map.get(n);
    }
}
