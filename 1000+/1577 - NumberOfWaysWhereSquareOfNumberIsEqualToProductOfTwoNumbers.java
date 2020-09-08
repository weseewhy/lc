/*
https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/

Given two arrays of integers nums1 and nums2, return the number of triplets formed (type 1 and type 2) under the following rules:
Type 1: Triplet (i, j, k) if nums1[i]2 == nums2[j] * nums2[k] where 0 <= i < nums1.length and 0 <= j < k < nums2.length.
Type 2: Triplet (i, j, k) if nums2[i]2 == nums1[j] * nums1[k] where 0 <= i < nums2.length and 0 <= j < k < nums1.length.

Example 1:
Input: nums1 = [7,4], nums2 = [5,2,8,9]
Output: 1
Explanation: Type 1: (1,1,2), nums1[1]^2 = nums2[1] * nums2[2]. (4^2 = 2 * 8).

Example 2:
Input: nums1 = [1,1], nums2 = [1,1,1]
Output: 9
Explanation: All Triplets are valid, because 1^2 = 1 * 1.
Type 1: (0,0,1), (0,0,2), (0,1,2), (1,0,1), (1,0,2), (1,1,2).  nums1[i]^2 = nums2[j] * nums2[k].
Type 2: (0,0,1), (1,0,1), (2,0,1). nums2[i]^2 = nums1[j] * nums1[k].

Example 3:
Input: nums1 = [7,7,8,3], nums2 = [1,2,9,7]
Output: 2
Explanation: There are 2 valid triplets.
Type 1: (3,0,2).  nums1[3]^2 = nums2[0] * nums2[2].
Type 2: (3,0,1).  nums2[3]^2 = nums1[0] * nums1[1].

Example 4:
Input: nums1 = [4,7,9,11,23], nums2 = [3,5,1024,12,18]
Output: 0
Explanation: There are no valid triplets.

Constraints:
    . 1 <= nums1.length, nums2.length <= 1000
    . 1 <= nums1[i], nums2[i] <= 10^5
*/

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numTriplets_v1(int[] nums1, int[] nums2) {
        return v1(nums1, nums2) + v1(nums2, nums1);
    }

    private int v1(int[] nums1, int[] nums2) {
        int cnt = 0;
        Map<BigInteger, Integer> map = new HashMap<>();
        for (int i : nums1) {
            BigInteger sq = BigInteger.valueOf(i).multiply(BigInteger.valueOf(i));
            map.put(sq, map.getOrDefault(sq, 0) + 1);
        }

        for (int i = 0; i < nums2.length - 1; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                BigInteger prod = BigInteger.valueOf(nums2[i]).multiply(BigInteger.valueOf(nums2[j]));
                cnt += map.getOrDefault(prod, 0);
            }
        }

        return cnt;
    }

    /*################################################################################*/

    public int numTriplets_v2(int[] nums1, int[] nums2) {
        return v2(nums1, nums2) + v2(nums2, nums1);
    }

    // Save in a map so that we do it only once of such val
    private int v2(int[] sq_arr, int[] prd_arr) {
        // Square values and it's count
        Map<Long, Integer> sq_map = new HashMap<>();
        for (long num : sq_arr) {
            long sq = num * num;
            sq_map.put(sq, sq_map.getOrDefault(sq, 0) + 1);
        }

        // Number from nums2 and their count
        Map<Long, Integer> prd_map = new HashMap<>();
        for (long num : prd_arr) {
            prd_map.put(num, prd_map.getOrDefault(num, 0) + 1);
        }

        int cnt = 0;
        for (Map.Entry<Long, Integer> entry : sq_map.entrySet()) {
            Long sq = entry.getKey();
            int sq_cnt = entry.getValue();

            int localCnt = 0;
            for (long oneNum : prd_map.keySet()) {
                // Check if square is divisible by one num
                // If so, check if the other num is in the list
                if (sq % oneNum != 0) continue;

                int oneNumCnt = prd_map.get(oneNum);
                long otherNum = sq / oneNum;
                if (oneNum == otherNum) {
                    // Perfect square -- number of combinations = n*(n-1)/2
                    localCnt += oneNumCnt * (oneNumCnt - 1) * sq_cnt;
                } else if (prd_map.containsKey(otherNum)) {
                    // We will count twice [one, other], [other, one]. 
                    // so divide the final result by 2
                    // Do it only till sq_root to avoid this 
                    int otherNumCnt = prd_map.get(otherNum);
                    localCnt += oneNumCnt * otherNumCnt * sq_cnt;
                }
            }

            // denominator 2 from both cases above
            cnt += localCnt / 2;
        }

        return cnt;
    }
}
