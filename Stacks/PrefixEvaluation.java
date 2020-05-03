
// what if operand is larger than length 1
// what if it has floating/double numbers
// Complexity

import java.util.Stack;

public class PrefixEvaluation {

    public static int evaluatePreFixExpression(String str) {

        String[] strs = str.split(" ");

        Stack<Integer> st = new Stack<Integer>();

        int len = strs.length;

        for (int i = len - 1; i >= 0; i--) {

            String str1 = strs[i];

            if (isSupportedEqualsOperator(str1)) {

                var op1 = st.pop();
                var op2 = st.pop();

                st.push(performOperation(str1, op1, op2));
            } else {
                st.push(convertStringToInt(str1));
            }
        }

        return st.pop();
    }

    public static boolean isSupportedEqualsOperator(String str) {
        if (str.equals("+") || str.equals("/") || str.equals("*") || str.equals("-")) {
            return true;
        } else {
            return false;
        }
    }

    public static int convertStringToInt(String str) {
        return str.charAt(0) - '0';
    }

    public static int performOperation(String str, int op1, int op2) {

        int result;
        if (str.equals("+")) {
            result = op1 + op2;
        } else if (str.equals("-")) {
            result = op1 - op2; // Tricky case in substraction
        } else if (str.equals("*")) {
            result = op1 * op2;
        } else {
            result = op1 / op2;
        }

        return result;
    }

    public static void main(String[] args) {

        // String expression = "- + 8 / 6 3 2";
        String expression = "- + 7 * 4 5 + 2 0";

        int result = evaluatePreFixExpression(expression);

        System.out.println(result);
    }
}