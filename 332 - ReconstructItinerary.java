/*
https://leetcode.com/problems/reconstruct-itinerary/

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary
that has the smallest lexical order when read as a single string.
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].

Example 1:
Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:
Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
*/

import java.util.*;

class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> ticketMap = new HashMap<>();
        for (String[] arr : tickets) {
            String from = arr[0];
            String to = arr[1];
            if (!ticketMap.containsKey(from)) {
                ticketMap.put(from, new ArrayList<>());
            }

            ticketMap.get(from).add(to);
        }

        for (List<String> c : ticketMap.values()) {
            Collections.sort(c);
        }

        List<String> path = new ArrayList<>();
        visit("JFK", ticketMap, tickets.length + 1, path);
        return path;
    }

    private boolean visit(String from, Map<String, List<String>> ticketMap, int remaining, List<String> path) {
        path.add(from);
        remaining--;

        if (remaining == 0) {
            return true;
        }

        boolean success = false;
        if (ticketMap.containsKey(from)) {
            for (int i = 0; i < ticketMap.get(from).size(); i++) {
                String to = ticketMap.get(from).get(i);
                ticketMap.get(from).remove(i);
                if (visit(to, ticketMap, remaining, path)) {
                    return true;
                } else {
                    ticketMap.get(from).add(i, to);
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    // Hierholzer's algorithm to find a Eulerian path
    // https://leetcode.com/problems/reconstruct-itinerary/discuss/78766
    // https://www.youtube.com/watch?v=8MpoO2zA2l4
    public List<String> findItinerary2(String[][] tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }

        LinkedList<String> path = new LinkedList<>();
        dfs("JFK", flights, path);
        return path;
    }

    private void dfs(String departure, Map<String, PriorityQueue<String>> flights, LinkedList<String> path) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, path);
        }
        path.addFirst(departure);
    }
}
