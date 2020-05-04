/*
https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

Given the array candies and the integer extraCandies, where candies[i] represents the number of candies 
that the ith kid has. For each kid check if there is a way to distribute extraCandies among the kids such that 
he or she can have the greatest number of candies among them. 
Notice that multiple kids can have the greatest number of candies.

Example 1:
Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true] 
 
Example 2:
Input: candies = [4,2,1,1,2], extraCandies = 1
Output: [true,false,false,false,false] 

Example 3:
Input: candies = [12,1,12], extraCandies = 10
Output: [true,false,true]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }

        List<Boolean> out = new ArrayList<>();
        for (int val : candies) {
            out.add(val + extraCandies >= max);
        }

        return out;
    }
}
