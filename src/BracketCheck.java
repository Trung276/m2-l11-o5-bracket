import java.util.*;

public class BracketCheck {
    public static boolean isBalanced(String expression) {
        Stack<Character> bStack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char sym = expression.charAt(i);
            if (sym == '(') {
                bStack.push(sym);
            } else if (sym == ')') {
                if (bStack.isEmpty()) {
                    return false;
                }
                char left = bStack.pop();
                if (sym == ')' && left != '(') {
                    return false;
                }
            }
        }
        return bStack.isEmpty();
    }

    public static void main(String[] args) {
        String expression1 = "s * (s – a) * (s – b) * (s – c)";
        System.out.println("Expression 1 is balanced: " + isBalanced(expression1));
        String expression2 = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        System.out.println("Expression 2 is balanced: " + isBalanced(expression2));
        String expression3 = "s * (s – a) * (s – b * (s – c)";
        System.out.println("Expression 3 is balanced: " + isBalanced(expression3));
        String expression4 = "s * (s – a) * s – b) * (s – c)";
        System.out.println("Expression 4 is balanced: " + isBalanced(expression4));
    }
}