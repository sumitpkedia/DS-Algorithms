
// what if operand is larger than length 1 "542" => (2 - '0') * 10 pow 0 + (4 - '0') * 10 pow 1 + (5 - '0') * 10 pow 2
// what if it has floating/double numbers 1.2 , 0.7 => .84 => 0
// Datatype - range int (0 - 2 pow 31) 
// 2 pow 64 +/* 2 pow 64 = not supported - out of range     
// Complexity 

import java.util.Stack;

public class PostfixEvaluation {

    public static int evaluatePostFixExpression(String exp) {

        // Null, length check
        // considering valid strings
        String[] strs = exp.split(" ");
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < strs.length; i++) {

            // operator
            if (isSupportedEqualsOperator(strs[i])) {

                // considering single digit ooerator

                int op1 = 0;
                int op2 = 0;

                if (st.size() > 0)
                    op1 = st.pop();

                if (st.size() > 0)
                    op2 = st.pop();

                st.push(performOperation(strs[i], op1, op2));

            } else { // operator
                st.push(convertStringToInt(strs[i]));
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

        System.out.println(str);

        return str.charAt(0) - '0';
    }

    public static int performOperation(String str, int op1, int op2) {

        // 2 pow 64 +/* 2 pow 64 = not supported - out of range 
        int result;
        if (str.equals("+")) {
            result = op2 + op1;
        } else if (str.equals("-")) {
            result = op2 - op1;  // Tricky case
        } else if (str.equals("*")) {
            result = op2 * op1;
        } else {
            result = op2 / op1;
        }

        return result;
    }

    public static void main(String[] args) {

        String expression = "5 1 2 + 4 * + 3 -";

        int result = evaluatePostFixExpression(expression);

        System.out.println(result);

    }
}