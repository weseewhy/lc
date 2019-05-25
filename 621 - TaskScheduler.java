/*
https://leetcode.com/problems/task-scheduler/

Given a char array representing tasks CPU need to do. 
It contains capital letters A to Z where different letters represent different tasks. 
Tasks could be done without original order. Each task could be done in one interval. 
For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, 
there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
*/

import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Task> map = new HashMap<>();
        for (char c : tasks) {
            map.putIfAbsent(c, new Task(c));
            map.get(c).cnt++;
        }

        // PQ to hold the available tasks
        // Pick the one with highest cnt (If same cnt, sort by name)
        PriorityQueue<Task> available = new PriorityQueue<>((t1, t2) -> t1.cnt != t2.cnt ? t2.cnt - t1.cnt : t1.name - t2.name);

        // Queue to hold the tasks that are in cool-down phase
        Queue<Task> coolDown = new LinkedList<>();

        for (Task t : map.values()) {
            available.offer(t);
        }

        int time = 0;
        while (!available.isEmpty() || !coolDown.isEmpty()) {
            time++;

            if (!coolDown.isEmpty() && coolDown.peek().availableAt == time) {
                available.offer(coolDown.poll());
            }

            if (!available.isEmpty()) {
                Task t = available.poll();
                t.cnt--;
                if (t.cnt > 0) {
                    t.availableAt = time + n + 1;
                    coolDown.offer(t);
                }
            }
        }

        return time;
    }
}

class Task {
    char name;
    int cnt;
    int availableAt;

    Task(char name) {
        this.name = name;
        this.cnt = 0;
        this.availableAt = 1;
    }
}
