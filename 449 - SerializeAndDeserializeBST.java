/*
https://leetcode.com/problems/serialize-and-deserialize-bst/

Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, or transmitted across a network connection 
link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary search tree can be serialized to a string and 
this string can be de-serialized to the original tree structure.

The encoded string should be as compact as possible.
*/

public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }

        sb.append(root.val);
        if (root.left != null) {
            sb.append(",").append(serialize(root.left));
        }
        if (root.right != null) {
            sb.append(",").append(serialize(root.right));
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        String[] strNums = data.split(",");
        int[] nums = new int[strNums.length];
        for (int i = 0; i < strNums.length; i++) {
            nums[i] = Integer.valueOf(strNums[i]);
        }

        return deserialize(nums, 0, nums.length - 1);
    }

    private TreeNode deserialize(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(nums[start]);

        int rightStart = start + 1;
        while (rightStart <= end && nums[rightStart] <= root.val) {
            rightStart++;
        }

        root.left = deserialize(nums, start + 1, rightStart - 1);
        root.right = deserialize(nums, rightStart, end);

        return root;
    }
}
