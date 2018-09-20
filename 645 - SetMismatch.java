/*
https://leetcode.com/problems/set-mismatch/

The set S originally contains numbers from 1 to n. But unfortunately, due to the data error,
one of the numbers in the set got duplicated to another number in the set,
which results in repetition of one number and loss of another number.
Given an array nums representing the data status of this set after the error.
Your task is to firstly find the number occurs twice and then find the number that is missing.
Return them in the form of an array.

Example 1:
Input: [1,2,2,4]
Output: [2,3]
*/

import java.util.HashSet;
import java.util.Set;

public class SetMismatch {

    public int[] findDuplicateNumbers(int[] input) {
        Set<Integer> set = new HashSet<>();
        int[] out = new int[2];
        for (int i : input) {
            if (set.contains(i)) {
                out[0] = i;
            } else {
                set.add(i);
            }
        }

        for (int i = 1; i <= input.length; i++) {
            if (!set.contains(i)) {
                out[1] = i;
                break;
            }
        }

        return out;
    }
}
