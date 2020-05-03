
public class BalancedParenthesis {

    // Considering string has only brackets - round one.
    public static boolean IsBalancedParaString(String str) {

        // Check for null condition etc
        // Other chars....
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {
                count++;
            } else if (str.charAt(i) == ')') {

                if (count <= 0) {
                    return false;
                }

                count--;
            }
        }

        if (count != 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        String str = ")(((()()()(((((())(()))))()()()()(((((((";
        // str = "((((()))))";
        // counter = 0
        // ( ) ( )
        // 1 0 1 0 => valid
        // )))) ()() => invalid

        System.out.println(IsBalancedParaString(str));

    }

}
