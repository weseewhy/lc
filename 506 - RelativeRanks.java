/*
https://leetcode.com/problems/relative-ranks/

Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
For the left two athletes, you just need to output their relative ranks according to their scores.

Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        String[] out = new String[nums.length];
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i : nums) {
            list.add(i);
        }
        list.sort(Collections.reverseOrder());
        System.out.println(list);

        for (int i = 0; i < nums.length; i++) {
            int rank = list.indexOf(nums[i]) + 1;
            out[i] = rank == 1 ? "Gold Medal" : rank == 2 ? "Silver Medal" : rank == 3 ? "Bronze Medal" : String.valueOf(rank);
        }

        return out;
    }
}
