/*
https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/

In an infinite binary tree where every node has two children, the nodes are labelled in row order.
In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right,
while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.

Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.

Example 1:
Input: label = 14
Output: [1,3,4,14]

Example 2:
Input: label = 26
Output: [1,2,6,10,26]

Constraints: 1 <= label <= 10^6
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> out = new ArrayList<>();
        out.add(label);

        int level = getLevel(label);
        int original = level % 2 == 0 ? findComplement(label, level) : label;

        while (original > 1) {
            level--;
            original = original / 2;
            out.add(level % 2 == 0 ? findComplement(original, level) : original);
        }

        Collections.reverse(out);
        return out;
    }

    // In nth level, sum of first and last = 2^(n-1) + 2^n - 1
    private int findComplement(int num, int level) {
        return 3 * ((int) Math.pow(2, level - 1)) - 1 - num;
    }

    private int getLevel(int i) {
        int level = 0;
        while (i > 0) {
            i = i >> 1;
            level++;
        }
        return level;
    }
}
