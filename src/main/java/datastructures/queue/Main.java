package datastructures.queue;

public class Main {

    public static void main(String[] args) {
        Queue myQueue = new Queue(2);
        myQueue.printQueue();

        System.out.println("Add couple of values ::: ");

        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.printQueue();

    }

}
