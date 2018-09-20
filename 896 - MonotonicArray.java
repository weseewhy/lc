/*
https://leetcode.com/problems/monotonic-array

An array is monotonic if it is either monotone increasing or monotone decreasing.
An array A is monotone increasing if for all i <= j, A[i] <= A[j].
An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
Return true if and only if the given array A is monotonic.
*/

public class MonotonicArray {

    public boolean isMonotonic(int[] input) {
        return isNonIncreasing(input) || isNonDecreasing(input);
    }

    private boolean isNonDecreasing(int[] input) {
        if (input.length == 1) {
            return true;
        }

        for (int i = 1; i < input.length; i++) {
            if (input[i] < input[i - 1]) {
                return false;
            }
        }

        return true;
    }

    private boolean isNonIncreasing(int[] input) {
        if (input.length == 1) {
            return true;
        }

        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
