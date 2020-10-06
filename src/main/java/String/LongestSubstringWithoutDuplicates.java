package String;

import java.util.HashMap;

/**
 * LeetCode 3: Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.


 * Solve with Two Pointers
 * Use HashMap, key is ith character, value is i.
 * traverse all characters, if duplicate chars found, update j to index of dup+1
 * Keep max updated at each iteration, max = Math.max(max, i-j+1).
 * keep updating HashMap so that index is always the newest
 */
public class LongestSubstringWithoutDuplicates {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
