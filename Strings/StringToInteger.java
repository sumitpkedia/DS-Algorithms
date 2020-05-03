
public class StringToInteger {

    public static int stringToInteger(String str) {

        // null check/validation

        int len = str.length() - 1;
        boolean digitFound = false;
        boolean isNegative = false;
        int index = 0;
        // check for possibility of space and words.
        while (index <= len) {

            char c = str.charAt(index);
            if (c == ' ') {
                index++;
                continue;
            } else if (c == '-') {

                if ((index + 1 <= len) && isDigit(str.charAt(index + 1))) {
                    isNegative = true;
                    break;
                } else {
                    return 0;
                }

            } else if (!isDigit(str.charAt(index))) {
                return 0;
            } else if (isDigit(str.charAt(index))) {
                break;
            }
            index++;

            System.out.println("insdie first while loop ");

        }

        while (len >= index) {

            System.out.println("insdie Second while loop ");

            if (!isDigit(str.charAt(len))) {
                len--;
                continue;
            }
            break;
        }

        int powCount = 0;
        int num = 0;
        int resultnum = 0;
        while (len >= index) {

            // Corner cases
            if (!isDigit(str.charAt(len))) {
                break;
            }
                    // 987
                    // 7 * 10 pow 0 = 7
                    // 7 + 8 * 10 po 1= 87
                    // 87 + 900 = 987
            num = (str.charAt(len) - '0') * (int) Math.pow(10, powCount);
            resultnum = resultnum + num;
            powCount++;
            len--;
            System.out.println("insdie while loop " + resultnum);
        }

        if (isNegative) {
            resultnum = resultnum * -1;
        }

        return resultnum;
    }

    public static boolean isDigit(char c) {
        int digit = c - '0';

        if (digit >= 0 && digit <= 9)
            return true;

        return false;
    }

    public static void main(String[] args) {

        String str = "  asdasdsd   -42 jhghjsd sjdhgd sdsd";

        int result = stringToInteger(str);

        System.out.println(result);
    }
}