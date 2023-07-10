import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {

    static HashMap<Character, Character> mappings;
    static HashMap<Character, Character> mappings1;

    public static void main(String[] args)
    {
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        mappings1 = new HashMap<>();
        mappings1.put('(', ')');
        mappings1.put('{', '}');
        mappings1.put('[', ']');

//        String s = "()[[]}{}{}";
        String s = "([{)(])(})";
        if(isValid(s)) {
            System.out.println("Is Valid");
        } else {
            System.out.println("Is Invalid");
        }

        if(isValid1(s)) {
            System.out.println("Is Valid");
        } else {
            System.out.println("Is Invalid");
        }
    }

    public static Boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i=0; i <s.length(); i++) {
            char c = s.charAt(i);

            if(mappings.containsKey(c)) {
                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if(topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public static Boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(mappings1.containsKey(c)) {
                stack.push(c);
            } else {
                if(mappings1.isEmpty() || mappings1.get(stack.pop()) !=c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
