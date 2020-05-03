import java.util.*;

/*
Ex: -
    //      | |
    // "e c e b"
    // hm - e - 1, b - 1
 */

public class maxSubStringKDistinct {

    public static int maxSubStringSizeKDistinctChars(String str, int k) {

        // validation for k and string length
        int start = 0;
        int maxLen = 0;
        int localSum = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int end = 0; end < str.length(); end++) {

            localSum++;
            if (hm.containsKey(str.charAt(end))) {
                hm.put(str.charAt(end), hm.get(str.charAt(end)) + 1);
            } else {
                hm.put(str.charAt(end), 1);
            }

            while(hm.size() > k) {
               // maxLen = Math.max(maxLen, end - start);
                maxLen = Math.max(maxLen, localSum - 1);
                hm.put(str.charAt(start), hm.get(str.charAt(start)) - 1);
                if(hm.get(str.charAt(start)) == 0) {
                    hm.remove(str.charAt(start));
                }
                start++;
                localSum--;
            }
        }

        return Math.max(maxLen, localSum);

    }

    public static void main(String[] args) {

        int result = maxSubStringSizeKDistinctChars("aa", 1);
        System.out.println(result);
    }
}