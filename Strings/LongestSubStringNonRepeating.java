import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStringNonRepeating {

    public static int longestSubStringLengthNonRepeating(String str) {

        // null validation check string

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        int j = 0;
        int max = 0;
        for (int index = 0; index < str.length(); index++) {

            if (hm.containsKey(str.charAt(index))) {
                j = Math.max(j, hm.get(str.charAt(index)) + 1);
            }

            hm.put(str.charAt(index), index);
            max = Math.max(max, index - j + 1);

        }

        return max;
    }

    public static int LongestSubStringNonRepeatingSecondAttempt(String str) {

        HashMap<Character, Integer> hm = new HashMap<>();

        int len = 0;
        int startPosition = 0;
        int maxResult = 0;
        for (int i = 0; i < str.length(); i++) {
            if (hm.containsKey(str.charAt(i))) {
                // New start position for uniqueness
                // which will be from next index position
                // because same position is having repeated character
                startPosition = Math.max(startPosition, hm.get(str.charAt(i)) + 1);
            }

            hm.put(str.charAt(i), i);

            // i is end position until now (which is end position)
            // Since its index based ith position - we add 1 to result.
            maxResult = Math.max(maxResult, i - startPosition + 1);
        }

        return maxResult;
    }

    public static int LongestSubStringNonRepeatingThirdWay(String str) {

        Set<Character> set = new HashSet<>();
        int len = str.length();
        int maxResult = 0;

        // Two pointers concepts begin and end,
        int start = 0;
        int end = 0;

        while (end < len) {

            if (set.contains(str.charAt(end))) {

                // We are removing from start always
                // This make sure repeated characters are also deleted.
                // tricky
                set.remove(str.charAt(start));
                start++;
            } else {

                set.add(str.charAt(end));
                maxResult = Math.max(maxResult, set.size());
                end++;
            }
        }

        return maxResult;
    }

    public static void main(String[] args) {

        /*
         * 
         * A,B,C,D,A => ABCD
         * 
         * i = 0,1,2,3,4 String str = "A,B,C,D,   A    BDEFGCABD";
         * 
         * curlength ++; maxlength
         * 
         */

        /*
         * str[i] buffer[str[i]] = {-1,-1, -1,-1, -1, -1, .....} => position of letter
         * in string buffer[str[0] => A] = 0 buffer[str[1] => B] = 1 buffer[str[1] => C]
         * = 2
         * 
         * {....., 0, 1, 2, 3, } "ABCD   A  BDEFGCABD"
         * 
         * "A BCDA B DEFGCABD"
         * 
         * "AB CDAB D EFGCABD" A BCDA ABCD
         */

        String str = "ABCDABDEFGCABD";

        // int len = longestSubStringLengthNonRepeating(str);
        // int len = LongestSubStringNonRepeatingSecondAttempt(str);
        int len = LongestSubStringNonRepeatingThirdWay(str);

        System.out.println("Longest Strings " + len);

    }

}