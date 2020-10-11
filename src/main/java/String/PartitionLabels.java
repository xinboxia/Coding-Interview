package String;
import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 763. Partition Labels
 * A string S of lowercase English letters is given. We want to partition this string into
 * as many parts as possible so that each letter appears in at most one part,
 * and return a list of integers representing the size of these parts.
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 *
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 */
// Use two pointers
// Time Complexity: O(n)
// Space Complexity: O(n)
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] last = new int[26];
        //find the last occurrence of each character
        for(int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        int start = -1, end = -1;
        for(int i = 0; i < S.length(); i++) {
            if(start == -1) {
                start = i;
            }
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if(end == i) {
                result.add(end-start+1);
                start=-1;
            }
        }
        return result;
    }
}
