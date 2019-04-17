/*
https://leetcode.com/problems/shuffle-an-array/

Shuffle a set of numbers without duplicates.

Example:
// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
*/

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        int[] shuffle = new int[nums.length];
        Set<Integer> used = new HashSet<>();

        for (int i = 0; i < shuffle.length; i++) {
            boolean found = false;
            while (!found) {
                int randIndex = random.nextInt(nums.length);
                if (!used.contains(randIndex)) {
                    used.add(randIndex);
                    shuffle[i] = nums[randIndex];
                    found = true;
                }
            }
        }

        return shuffle;
    }
}

/*
Alternative:
Fisher-Yates Algorithm
https://leetcode.com/problems/shuffle-an-array/solution/
*/
