/*
https://leetcode.com/problems/permutation-sequence/

The set [1,2,3,...,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:
Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.

Example 1:
Input: n = 3, k = 3
Output: "213"

Example 2:
Input: n = 4, k = 9
Output: "2314"
*/

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        int[] fact = getFactorialsArray(n);
        StringBuilder sb = new StringBuilder(n);
        getPermutation(nums, k, sb, fact);
        return sb.toString();
    }

    private void getPermutation(List<Integer> nums, int k, StringBuilder sb, int[] factorial) {
        if (k == 1) {
            nums.forEach(sb::append);
            return;
        }

        /*
        [1,2,3,4]
        Number of buckets = 4
        bucketSize = (4-1)! = 6
        Say k=12 ==> bucketNumber = (12-1)/bucketSize = 11/6 = 1 (0 based index)
         */
        int bucketSize = factorial[nums.size() - 1];
        int bucketNumber = ((k - 1) / bucketSize);
        sb.append(nums.remove(bucketNumber));
        k -= bucketNumber * bucketSize; // Remove filled up buckets

        getPermutation(nums, k, sb, factorial);
    }

    private int[] getFactorialsArray(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = i * arr[i - 1];
        }

        return arr;
    }
}
