
public class StringAnagram {

    // considering string with small case letters
    public static boolean checkForAnagram(String str1, String str2) {

        // Corner cases - null check , length check

        int len1 = str1.length();
        int len2 = str2.length();

        // boolean isAnagram = true;

        if (len1 != len2) {
            return false;
        }

        int[] arr = new int[256];
        int uniqueChars = 0;
        int stringChar;

        for (int i = 0; i < len1; i++) {

            stringChar = (int) str1.charAt(i) - 97;
            if (arr[stringChar] == 0) {
                uniqueChars++;
            }
            arr[stringChar] = arr[stringChar] + 1;
        }

        // arr[0, 0 , 1, 0 , 3, 1, 0, 0, 0 , 2, 0]

        for (int i = 0; i < len1; i++) {

            stringChar = str2.charAt(i) - 97;
            if (arr[stringChar] == 0) {
                return false;
            }

            arr[stringChar] = arr[stringChar] - 1;

            if (arr[stringChar] == 0) {
                uniqueChars--;
            }
        }

        if (uniqueChars != 0) {
            return false;
        }

        for (int i = 0; i < 256; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String str1 = "abab";
        String str2 = "aabb";
        boolean isAnagram = checkForAnagram(str1, str2);

        if (isAnagram) {
            System.out.println("Strings are anagram");
        } else {
            System.out.println("Strings are NOT anagram");
        }
    }

}
