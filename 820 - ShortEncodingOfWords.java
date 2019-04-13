import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length).reversed());

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.length() == 0 || sb.indexOf(word + "#") < 0) {
                sb.append(word).append("#");
            }
        }

        return sb.length();
    }

    public int minimumLengthEncoding_Optimized(String[] words) {
        Map<String, TrieNode> lastNodeForWord = new HashMap<>();
        TrieNode root = new TrieNode();

        // Construct the trie
        for (String word : words) {
            TrieNode cur = root;

            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                cur.child.putIfAbsent(c, new TrieNode());
                cur = cur.child.get(c);
            }

            // Save the last nodes for each word
            lastNodeForWord.put(word, cur);
        }

        int length = 0;
        for (String word : lastNodeForWord.keySet()) {
            if (lastNodeForWord.get(word).child.size() == 0) { // leaf node
                length += (word.length() + 1);
            }
        }

        return length;
    }
}

class TrieNode {
    Map<Character, TrieNode> child = new HashMap<>();
}
