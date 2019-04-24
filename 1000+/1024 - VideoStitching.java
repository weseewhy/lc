/*
You are given a series of video clips from a sporting event that lasted T seconds.
These video clips can be overlapping with each other and have varied lengths.

Each video clip clips[i] is an interval: it starts at time clips[i][0] and ends at time clips[i][1].
We can cut these clips into segments freely: for example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].

Return the minimum number of clips needed so that we can cut the clips into segments
that cover the entire sporting event ([0, T]).  If the task is impossible, return -1.


Example 1:
Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
Output: 3
Explanation: We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.

Example 2:
Input: clips = [[0,1],[1,2]], T = 5
Output: -1
Explanation: We can't cover [0,5] with only [0,1] and [0,2].

Example 3:
Input: clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
Output: 3
Explanation: We can take clips [0,4], [4,7], and [6,9].

Example 4:
Input: clips = [[0,4],[2,8]], T = 5
Output: 2
Explanation: Notice you can have extra video after the event ends.
*/

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int videoStitching(int[][] clips, int T) {
        // Sort by starts
        Arrays.sort(clips, Comparator.comparingInt(e -> e[0]));

        int maxReachable = 0;
        int cnt = 0;

        for (int i = 0; i < clips.length; ) {
            // There is gap between last stitched clip and current one
            // So not possible to combine them
            if (clips[i][0] > maxReachable) {
                return -1;
            }

            int nextMaxReachable = maxReachable;
            while (i < clips.length && clips[i][0] <= maxReachable) {
                // If current clip can help in next stitch, find the farthest we can go
                nextMaxReachable = Math.max(nextMaxReachable, clips[i][1]);
                i++;
            }

            // Found the clip that can reach "nextMaxReachable"
            cnt++;
            maxReachable = nextMaxReachable;

            // Check if we can stitch full length after current clip
            if (maxReachable >= T) {
                return cnt;
            }
        }

        return -1;
    }
}
