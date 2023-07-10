package datastructures.stackProblems;

import java.util.HashMap;

public class BalancedParentheses {

    public static boolean isBalancedParentheses(String str) {
        Stack<Character> stack = new Stack<>();

        for(char ch: str.toCharArray()) {
            if(ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValidParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> mappings = new HashMap<>();
        mappings.put('{', '}');
        mappings.put('[', ']');
        mappings.put('(', ')');

        for(char c: str.toCharArray()) {
            if(mappings.containsKey(c)) {
                stack.push(c);
            } else {
                if(mappings.isEmpty() || mappings.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()()()";
        String s2 = "()(()";
        String s3 = "(()())";
        System.out.println(isBalancedParentheses(s1)); // true
        System.out.println(isBalancedParentheses(s2)); // false
        System.out.println(isBalancedParentheses(s3)); // true

        /*
            EXPECTED OUTPUT:
            ----------------
            true
            false
            true
        */



        String s4 = "([{)(])(})";
        String s5 = "()(()";
        String s6 = "(({})([]))";
        System.out.println(isValidParentheses(s4)); // false
        System.out.println(isValidParentheses(s5)); // false
        System.out.println(isValidParentheses(s6)); // true

        /*
            EXPECTED OUTPUT:
            ----------------
            false
            false
            true
        */


    }
}
