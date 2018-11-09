/*
https://leetcode.com/problems/partition-labels/

A string S of lowercase letters is given. We want to partition this string
into as many parts as possible so that each letter appears in at most one part,
and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
*/

import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Position> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new Position(i));
            } else {
                map.get(c).setEnd(i);
            }
        }

        List<Position> positions = new ArrayList<>(map.values());
        Collections.sort(positions);

        List<Integer> out = new ArrayList<>();
        int start = positions.get(0).start;
        int end = positions.get(0).end;

        for (int i = 1; i < positions.size(); i++) {
            Position cur = positions.get(i);
            if (cur.start < end) {
                end = Math.max(end, cur.end);
            } else {
                out.add(end - start + 1);
                start = cur.start;
                end = cur.end;
            }
        }

        out.add(end - start + 1);
        return out;
    }
}

class Position implements Comparable<Position> {
    int start;
    int end;

    Position(int pos) {
        this.start = this.end = pos;
    }

    void setEnd(int end) {
        this.end = end;
    }

    @Override
    public int compareTo(Position another) {
        return this.start - another.start;
    }
}
