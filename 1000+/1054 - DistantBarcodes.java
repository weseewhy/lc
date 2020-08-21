/*
https://leetcode.com/problems/distant-barcodes/

In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].
Rearrange the barcodes so that no two adjacent barcodes are equal.
You may return any answer, and it is guaranteed an answer exists.

Example 1:
Input: [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]

Example 2:
Input: [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,2,1,2,1]

Note:
    1 <= barcodes.length <= 10000
    1 <= barcodes[i] <= 10000
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int code : barcodes) {
            cntMap.put(code, cntMap.getOrDefault(code, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(cntMap.entrySet());
        list.sort((e1, e2) -> e2.getValue() - e1.getValue());

        int[] out = new int[barcodes.length];
        int index = 0;

        for (Map.Entry<Integer, Integer> entry : list) {
            int val = entry.getKey();
            int cnt = entry.getValue();
            while (cnt-- > 0) {
                out[index] = val;
                index += 2;
                if (index >= barcodes.length) {
                    index = 1;
                }
            }
        }

        return out;
    }
}
