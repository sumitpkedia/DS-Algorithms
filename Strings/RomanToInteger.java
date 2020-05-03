import java.io.Console;

public class RomanToInteger {

    public static int convertRomanToInteger(String str) {
        // null check /validation
        if (str == null || str.length() == 0)
            return 0;

        int len = str.length() - 1;
        int result = 0;

        while (len >= 0) {

            int num = getNumber(str.charAt(len));

            // IV , XC => 90
            // V = 5 => num
            // I => 1
            if (len - 1 >= 0 && getNumber(str.charAt(len - 1)) < num) {

                num = num - getNumber(str.charAt(len - 1));
                len--;
            }

            result = result + num;
            len--;

        }

        return result;

    }

    public static int getNumber(char c) {

        int num = 0;
        if (c == 'I')
            num = 1;
        else if (c == 'V')
            num = 5;
        else if (c == 'X')
            num = 10;
        else if (c == 'L')
            num = 50;
        else if (c == 'C')
            num = 100;
        else if (c == 'D')
            num = 500;
        else if (c == 'M')
            num = 1000;

        return num;
    }

    public static void main(String[] args) {

        String str = "LVIII";

        int result = convertRomanToInteger(str);

        System.out.println(result);

    }
}