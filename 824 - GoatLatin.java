/*
https://leetcode.com/problems/goat-latin/

A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
The rules of Goat Latin are as follows:

1) If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
   For example, the word 'apple' becomes 'applema'.

2) If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
   For example, the word "goat" becomes "oatgma".
 
3) Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
   For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.

Return the final sentence representing the conversion from S to Goat Latin. 

Example 1:
Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

Example 2:
Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
*/

class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split("\\s+");
        StringBuilder suffix = new StringBuilder("ma");
        StringBuilder out = new StringBuilder();

        String cur;
        for (int i = 0; i < words.length; i++) {
            cur = words[i];

            if (startsWithVowel(cur)) {
                out.append(cur);
            } else {
                if (cur.length() > 1) {
                    out.append(cur.substring(1));
                }
                out.append(cur.charAt(0));
            }

            suffix.append("a");
            out.append(suffix);

            if (i != words.length - 1) {
                out.append(" ");
            }
        }

        return out.toString();
    }

    private boolean startsWithVowel(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        return "aeiouAEIOU".indexOf(word.charAt(0)) > -1;
    }
}
