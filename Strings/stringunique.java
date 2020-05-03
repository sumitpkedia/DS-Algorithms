import java.io.Console;

public class stringunique {

    public static void main(String[] args) {

        // System.out.println("testing");

        String str = "ramisaboy";
        boolean isunique = findUniqueString(str);

        if (isunique) {
            System.out.println("unique only");
        } else {
            System.out.println("Not unique");
        }
    }

    public static boolean findUniqueString(String str) {

        if (str == null) {
            return false;
        }

        int[] arr = new int[256];

        for (int i = 0; i < str.length(); i++) {

            if (arr[i] != 0) {
                return false;
            }

            arr[(int) str.charAt(i) - 97] = 1;
        }

        return true;
    }

    // abcABC1234 - alphanumerics (65 - 90 , 49- 57) , 97 , 122)
    // abcABC1234+-/ -
    // string to integer conversion

    public static boolean findUniqueString1(String str) {

        if (str == null) {
            return false;
        }

        int[] arr = new int[256];

        for (int i = 0; i < str.length(); i++) {

            if (arr[i] != 0) {
                return false;
            }

            arr[(int) str.charAt(i) - 97] = 1;
        }

        return true;
    }

    /*
    0000 0000 0000 0001 0000
     * "hehello" => "h" - 'a' = 4
     *              e - 'a' = 5
     * 
     * checker = 0
     * 1 << 4 = 000010000 & checker > 0
     * 
     * checker = checker | 000010000  = > 000010000
     * 1 << 5 = 0000100000 & checker > 0
     *checker = checker | 000010000  = > 000110000
     * 
     * 000110000 & 000010000 
     * 
     */

}