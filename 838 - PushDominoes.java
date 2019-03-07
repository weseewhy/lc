/*
https://leetcode.com/problems/push-dominoes/

There are N dominoes in a line, and we place each domino vertically upright.
In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
After each second, each domino that is falling to the left pushes the adjacent domino on the left.
Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

Given a string "S" representing the initial state. 
  S[i] = 'L', if the i-th domino has been pushed to the left; 
  S[i] = 'R', if the i-th domino has been pushed to the right; 
  S[i] = '.', if the i-th domino has not been pushed.

Return a string representing the final state. 

Example 1:
Input: ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."

Example 2:
Input: "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String pushDominoes(String dominoes) {
        char[] state = dominoes.toCharArray();
        Map<Integer, Integer> currentState = new HashMap<>();
        Map<Integer, Integer> nextState = new HashMap<>();

        for (int i = 0; i < state.length; i++) {
            char c = state[i];
            if (c == 'L') {
                currentState.put(i, -1);
            } else if (c == 'R') {
                currentState.put(i, 1);
            }
        }

        while (currentState.size() > 0) {
            for (Map.Entry<Integer, Integer> entry : currentState.entrySet()) {
                int nextPos = entry.getKey() + entry.getValue();
                if (nextPos < 0 || nextPos >= state.length) {
                    continue;
                }

                if (currentState.containsKey(nextPos) || (state[nextPos] != '.' && !nextState.containsKey(nextPos))) {
                    continue;
                }

                if (nextState.containsKey(nextPos)) {
                    nextState.remove(nextPos);
                    state[nextPos] = '.';
                } else {
                    nextState.put(nextPos, entry.getValue());
                    state[nextPos] = entry.getValue() == -1 ? 'L' : 'R';
                }
            }

            currentState = nextState;
            nextState = new HashMap<>();
        }

        return new String(state);
    }
}
