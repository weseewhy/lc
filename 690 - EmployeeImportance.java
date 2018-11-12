/*
https://leetcode.com/problems/employee-importance/

You are given a data structure of employee information, which includes the employee's unique id, 
his importance value and his direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. 
They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], 
and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. 
Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, 
you need to return the total importance value of this employee and all his subordinates.

Example 1:
Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
Output: 11
Explanation:
Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. 
They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.

*/

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = employees.stream()
                .collect(Collectors.toMap(e -> e.id, Function.identity()));

        Set<Integer> used = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(id);
        used.add(id);
        int totalImportance = 0;

        while (!queue.isEmpty()) {
            int eId = queue.pop();
            totalImportance += map.get(eId).importance;
            for (int sub : map.get(eId).subordinates) {
                if (!used.contains(sub)) {
                    queue.add(sub);
                    used.add(sub);
                }
            }
        }

        return totalImportance;
    }
}

class Employee {
    int id;
    int importance;
    List<Integer> subordinates;
}
