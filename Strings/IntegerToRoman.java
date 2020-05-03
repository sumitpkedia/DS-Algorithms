
public class IntegerToRoman {

    public static String convertIntegerToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        int temp = 0;
        // 525
        // 525/10 = 52
        // 525 % 10 = 5

        // 2025 => 2
        // MM
        while (num > 0) {

            if (num / 1000 > 0) {
                temp = num / 1000;
                num = num % 1000;
                while (temp > 0) {
                    sb.append("M");
                    temp--;
                }

            } else if (num / 500 > 0) {

                if (num / 900 > 0) {
                    sb.append("CM"); // => 900
                    num = num % 900;

                } else {
                    num = num % 500;
                    sb.append("D");
                }

            } else if (num / 100 > 0) {

                if (num / 400 > 0) {
                    sb.append("CD");
                    num = num % 400;
                } else {

                    temp = num / 100;
                    while (temp > 0) {
                        sb.append("C");
                        temp--;
                    }

                    num = num % 100;
                }

            } else if (num / 50 > 0) {

                if (num / 90 > 0) {
                    sb.append("XC");
                    num = num % 90;
                } else {
                    sb.append("L");
                    num = num % 50;
                }

            } else if (num / 10 > 0) {

                temp = num / 10;
                num = num % 10;
                while (temp > 0) {
                    sb.append("X"); // XXII
                    temp--;
                }
            } else if (num / 5 > 0) {

                if (num / 9 > 0) {
                    sb.append("IX");
                    num = num % 9;
                } else {
                    sb.append("V");
                    num = num % 5;
                }

            } else if (num / 1 > 0) {

                if (num / 4 > 0) {
                    sb.append("IV");
                    num = num % 4;
                } else {
                    temp = num / 1;
                    num = num % 1;
                    while (temp > 0) {
                        sb.append("I");
                        temp--;
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 2025;

        String str = convertIntegerToRoman(num);

        System.out.println(str);

    }
}