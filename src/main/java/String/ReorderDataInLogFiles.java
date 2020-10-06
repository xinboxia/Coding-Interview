package String;

import java.util.Arrays;

/**
 * LeetCode 937: Reorder Data in Log Files
 * You have an array of logs.  Each log is a space delimited string of words.
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.
 * It is guaranteed that each log has at least one word after its identifier.
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 */


/**
 * For comparator, return 1 means s1 > s2, so two elements need to be swapped
 * return 0, both ok to swap or not
 * return -1, no need to swap
 */

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            //Split string into two parts, first is log(let or dig), second is remaining
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            //if log is digit only, isDigit is true
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            //if both are letter-logs
            //compare first character
            if(!isDigit1 && !isDigit2) {
                int comp = split1[1].compareTo(split2[1]);
                if(comp == 0) return split1[0].compareTo(split2[0]);
                else return comp;
            }
            //if first is digit, second is letter
            //bring letter forward
            else if(isDigit1 && !isDigit2) {
                return 1;
            }
            //if both are digits
            //keep the order
            else if(isDigit1 && isDigit2) {
                return 0;
            }
            //if first is letter, second is digit
            //keep the order
            else {
                return -1;
            }
        });
        return logs;
    }
}
