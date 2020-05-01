/*
https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/

Given a function  f(x, y) and a value z, return all positive integer pairs x and y where f(x,y) == z.
The function is constantly increasing, i.e.:
    . f(x, y) < f(x + 1, y)
    . f(x, y) < f(x, y + 1)

For custom testing purposes you're given an integer function_id and a target z as input, 
where function_id represent one function from an secret internal list, on the examples you'll 
know only two functions from the list. You may return the solutions in any order.

Example 1:
Input: function_id = 1, z = 5
Output: [[1,4],[2,3],[3,2],[4,1]]
Explanation: function_id = 1 means that f(x, y) = x + y

Example 2:
Input: function_id = 2, z = 5
Output: [[1,5],[5,1]]
Explanation: function_id = 2 means that f(x, y) = x * y

Constraints:
    . 1 <= function_id <= 9
    . 1 <= z <= 100
    . It's guaranteed that the solutions of f(x, y) == z will be on the range 1 <= x, y <= 1000
    . It's also guaranteed that f(x, y) will fit in 32 bit signed integer if 1 <= x, y <= 1000
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customFunction, int z) {
        List<List<Integer>> out = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y >= 1) {
            int val = customFunction.f(x, y);
            if (val < z) {
                x++;
            } else if (val > z) {
                y--;
            } else {
                out.add(Arrays.asList(x, y));
                x++;
                y--;
            }
        }

        return out;
    }
}

interface CustomFunction {
    int f(int x, int y);
};
