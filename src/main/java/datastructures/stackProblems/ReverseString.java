package datastructures.stackProblems;

import java.util.Stack;

public class ReverseString {

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for(char c: str.toCharArray()) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);

        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */

    }

}
