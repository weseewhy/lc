/*
https://leetcode.com/problems/find-duplicate-subtrees/

Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees,
you only need to return the root node of any one of them.
Two trees are duplicate if they have the same structure with same node values.

Example:
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
Therefore, you need to return above trees' root in the form of a list.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> duplicates = new ArrayList<>();
        serialize(root, new HashMap<>(), duplicates);
        return duplicates;
    }

    private String serialize(TreeNode node, Map<String, Integer> serStringsCnt, List<TreeNode> duplicates) {
        if (node == null) {
            return "";
        }

        // Use prefix notation to serialize
        // Use () or - or , etc. as delimiters. otherwise two different trees can give same prefix string
        //              1         1
        //  Example:   /    and    \   can have same prefix 12
        //            2             2
        String ser = String.format("%d(%s)(%s)", node.val,
                serialize(node.left, serStringsCnt, duplicates),
                serialize(node.right, serStringsCnt, duplicates));

        serStringsCnt.put(ser, serStringsCnt.getOrDefault(ser, 0) + 1);
        if (serStringsCnt.get(ser) == 2) {
            duplicates.add(node);
        }

        System.out.println(ser);
        return ser;
    }
}
