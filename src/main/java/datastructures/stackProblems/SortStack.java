package datastructures.stackProblems;


public class SortStack {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> reverseSortedStack = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while(!reverseSortedStack.isEmpty() && reverseSortedStack.peek() > temp) {
                stack.push(reverseSortedStack.pop());
            }
            reverseSortedStack.push(temp);
        }
        while (!reverseSortedStack.isEmpty()) {
            stack.push(reverseSortedStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(4);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();

        /*
            EXPECTED OUTPUT:
            ----------------
            Before sorting:
            4
            1
            5
            2
            3

            After sorting:
            1
            2
            3
            4
            5

        */

    }

}
