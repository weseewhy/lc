/*
https://leetcode.com/problems/minimum-genetic-mutation/

A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
Suppose we need to investigate about a mutation (mutation from "start" to "end"),
where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene mutations.
A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine
what is the minimum number of mutations needed to mutate from "start" to "end".
If there is no such a mutation, return -1.

Note: If multiple mutations are needed, all mutations during in the sequence must be valid.

Example 1:
start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]
return: 1

Example 2:
start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
return: 2

Example 3:
start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
return: 3
*/

import java.util.*;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(bank.length);
        bankSet.addAll(Arrays.asList(bank));

        char[] options = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int level = 0;
        queue.offer(start);
        visited.add(start);

        // Do BFS generating all valid mutations
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return level;
                }

                // For each string, generate all valid NEW mutations
                char[] buffer = cur.toCharArray();
                for (int i = 0; i < buffer.length; i++) {
                    char originalChar = buffer[i];
                    for (char c : options) {
                        if (c != originalChar) {
                            buffer[i] = c;
                            String newMutation = new String(buffer);
                            if (bankSet.contains(newMutation) && !visited.contains(newMutation)) {
                                queue.offer(newMutation);
                                visited.add(newMutation);
                            }
                        }
                    }

                    buffer[i] = originalChar;
                }
            }

            level++;
        }

        return -1;
    }
}
