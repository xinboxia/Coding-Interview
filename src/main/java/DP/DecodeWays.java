package DP;

/**
 * LeetCode 91: Decode ways
 * classic DP question
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Input: s = "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 */
public class DecodeWays {
    public int numDecodings(String s) {
        //if string is null or empty, we have no way to decode.
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        //divide string of length n to n+1 sub-problems
        int[] dp = new int[n+1];
        //create base case
        dp[0] = 1;
        //if string is '0', no way to decode, otherwise, have 1 way to decode
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= n; i++) {
            //We only need to check itself and one digit before it plus itself(two digits)
            int first = Integer.parseInt(s.substring(i-1, i));
            int second = Integer.parseInt(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
