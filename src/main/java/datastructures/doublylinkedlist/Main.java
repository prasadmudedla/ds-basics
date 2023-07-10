package datastructures.doublylinkedlist;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);

        myDLL.printList();

        myDLL.append(2);
        System.out.println("After appending a value");
        myDLL.printList();

        myDLL.removeLast();
        System.out.println("After remove last:: ");
        myDLL.printList();

        myDLL.removeLast();
        System.out.println("After remove last once again:: " );
        myDLL.printList();

        System.out.println(myDLL.removeLast());
        System.out.println("After remove last once again:: " );
        myDLL.printList();

        myDLL.prepend(9);
        System.out.println("After prepending value");
        myDLL.printList();

        myDLL.prepend(4);
        myDLL.prepend(6);
        myDLL.prepend(14);
        myDLL.prepend(8);
        myDLL.prepend(5);
        myDLL.prepend(7);
        myDLL.prepend(15);
        myDLL.prepend(9);
        System.out.println("After prepending some more values");
        myDLL.printList();

        myDLL.removeFirst();
        System.out.println("After removing first element");
        myDLL.printList();

        int x = 5;
        Node node = myDLL.get(x);
        System.out.println("Get value of index " + x);
        if(node!=null) {
            System.out.println(node.value);
        } else {
            System.out.println("Null value at the index " + x);
        }

        System.out.println("Before reversing");
        myDLL.printList();

        myDLL.reverse();
        System.out.println("After reversing");
        myDLL.printList();

    }
}



