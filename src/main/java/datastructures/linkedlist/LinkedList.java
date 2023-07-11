package datastructures.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }


    public void printList() {
        Node temp = head;
        System.out.print("[");
        while(temp!= null) {
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
        System.out.println("]");
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }


    public void append(int n) {
        Node newNodeToAppend = new Node(n);
        if(length == 0) {
            head = newNodeToAppend;
            tail = newNodeToAppend;
        } else {
            tail.next = newNodeToAppend;
            tail = newNodeToAppend;
        }
        length++;
    }

    public Node removeLast() {
        if(length==0) {
            return null;
        }
        Node temp = head;
        Node pre = head;

        while(temp.next!= null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;
        if(length==0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNodeToPrepend = new Node(value);
        if(length==0) {
            head = newNodeToPrepend;
            tail = newNodeToPrepend;
        } else {
            newNodeToPrepend.next = head;
            head = newNodeToPrepend;
        }
        length++;
    }

    public Node removeFirst() {
        if(length==0) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length==0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index > length) {
            return null;
        }
        Node temp = head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp!=null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if(index <0 || index > length) {
            return false;
        }
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index==length) {
            append(value);
            return true;
        }
        Node newNodeToInsert = new Node(value);
        Node prevNode = get(index-1);
        newNodeToInsert.next = prevNode.next;
        prevNode.next = newNodeToInsert;
        length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index > length) {
            return null;
        }
        if(index==0) {
            return removeFirst();
        }
        if(index==length-1) {
            return removeLast();
        }
        Node prev = get(index-1);
        Node nodeToBeRemoved = prev.next;

        prev.next = nodeToBeRemoved.next;
        nodeToBeRemoved.next = null;
        length--;
        return nodeToBeRemoved;
    }

    public boolean reverse() {
        if(length == 0) {
            return false;
        }
        Node temp = head;
        head = tail;
        tail = temp;

        Node after;
        Node before = null;

        for(int i=0; i<length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        return true;
    }

    public Node findMiddleNode() {
        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer!=null && fastPointer.next!=null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    public boolean hasLoop() {
        Node slowPointer = head;
        Node fastPointer = tail;

        while(fastPointer!=null && fastPointer.next!=null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer) {
                return true;
            }

        }
        return false;

    }

    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for(int i=0; i<k; i++) {
            if(fast.next!=null) fast = fast.next;
            else return null;
        }

        while(fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public void reverseBetween(int m, int n) {
        if(head==null) {return; };
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        for(int i=0; i < m; i++) {
            prev = prev.next;
        }

        Node current = prev.next;

        for(int j=0; j < n-m; j++) {
            System.out.println("before " + j + " round :: " + "current:" + current.value + ", " + "prev:" + prev.value );
            Node temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
            System.out.println("after " + j + " round ::");
            printList();
        }
        head = dummy.next;
    }

    public void partitionList(int x) {
        if(head == null) { return; };
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        Node prev1 = dummy1;
        Node prev2 = dummy2;

        Node current;
        current = head;

        while(current!=null) {
            if(current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;

        head = dummy1.next;
    }

    public void removeDuplicates() {
        if(head == null) { return; }
        Set<Integer> values = new HashSet<>();
        Node prev = null;
        Node current = head;

        while (current!= null) {
            if(values.contains(current.value)) {
                prev.next = current.next;
                length-=1;
            } else {
                values.add(current.value);
                prev = current;
            }
            current = current.next;
        }

    }

    public void insertionSortOfLinkedList(LinkedList list) {
        if(list.length <2) {
            return;
        }
        Node sortedListHead = head;
        Node unsortedListHead = head.next;

        sortedListHead.next = null;

        while (unsortedListHead != null) {
            Node current = unsortedListHead;

            unsortedListHead = unsortedListHead.next;

            if(current.value < sortedListHead.value) {
                current.next = sortedListHead;
                sortedListHead = current;
            } else {
                Node searchPointer = sortedListHead;
                while (searchPointer.next!=null && current.value > searchPointer.value) {
                    searchPointer = searchPointer.next;
                }
                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }

        head = sortedListHead;
        Node temp = head;
        while (temp.next!=null) {
            temp = temp.next;
        }
        tail = temp;
    }

    public void merge(LinkedList otherList) {
        Node otherHead = otherList.getHead();
        Node dummy = new Node(0);
        Node current = dummy;

        while (head != null && otherHead != null) {
            if (head.value < otherHead.value) {
                current.next = head;
                head = head.next;
            } else {
                current.next = otherHead;
                otherHead = otherHead.next;
            }
            current = current.next;
        }

        if (head != null) {
            current.next = head;
        } else {
            current.next = otherHead;
            tail = otherList.getTail();
        }

        head = dummy.next;
        length += otherList.getLength();
    }

}


class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }

}