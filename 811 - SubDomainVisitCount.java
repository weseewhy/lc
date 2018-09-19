/*
https://leetcode.com/problems/subdomain-visit-count/

A website domain like "discuss.leetcode.com" consists of various subdomains. 
At the top level, we have "com", at the next level, we have "leetcode.com", 
and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", 
we will also visit the parent domains "leetcode.com" and "com" implicitly.

Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), 
followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".
We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, 
(in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.

Example:
Input: 
["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
Output: 
["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
Explanation: 
We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. 
For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubDomainVisitCount {
    public List<String> subDomainVisits(String[] domains) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : domains) {
            populate(s, countMap);
        }

        return countMap.entrySet().stream()
                .map(e -> String.format("%s %s", e.getValue(), e.getKey()))
                .collect(Collectors.toList());
    }

    private void populate(String s, Map<String, Integer> countMap) {
        String[] splits = s.split(" ");
        int cnt = Integer.valueOf(splits[0]);
        String domain = splits[1];
        countMap.put(domain, countMap.getOrDefault(domain, 0) + cnt);

        while (domain.contains(".")) {
            domain = domain.substring(domain.indexOf(".") + 1);
            countMap.put(domain, countMap.getOrDefault(domain, 0) + cnt);
        }
    }
}
