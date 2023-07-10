package datastructures.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);
        linkedList.printList();

        linkedList.append(2);

        System.out.println("After appending 2");
        linkedList.printList();

        linkedList.removeLast();
        System.out.println("After removing last");
        linkedList.printList();

        linkedList.prepend(6);
        linkedList.prepend(5);
        System.out.println("After prepending");
        linkedList.printList();

        linkedList.removeFirst();
        System.out.println("After removing first");
        linkedList.printList();

        System.out.println("Get value by index");
        System.out.println(linkedList.get(1).value);

        System.out.println("Before Insert");
        linkedList.printList();
        System.out.println("After Insert");
        linkedList.insert(2, 8);
        linkedList.printList();

        linkedList.remove(2);
        System.out.println("After Remove");
        linkedList.printList();

        System.out.println("After reverse");
        linkedList.reverse();
        linkedList.printList();

        System.out.println("After adding couple of values");
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(5);
        linkedList.printList();

        System.out.println("Middle Node is: " + linkedList.findMiddleNode().value);


        System.out.println("After adding couple of values");
        linkedList.append(7);
        linkedList.append(8);
        linkedList.append(9);
        linkedList.append(8);
        linkedList.append(7);

        linkedList.printList();

        int k = 2;
        System.out.print( k + " Node from End :: " );
        System.out.println(linkedList.findKthFromEnd(k).value);


        linkedList.reverseBetween(2,6);
        linkedList.printList();

        linkedList.partitionList(5);
        linkedList.printList();

        linkedList.removeDuplicates();
        System.out.println("After deleting duplicates");
        linkedList.printList();




    }
}
