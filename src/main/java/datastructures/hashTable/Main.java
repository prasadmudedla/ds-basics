package datastructures.hashTable;

public class Main {
    public static void main(String[] args) {
        HashTable myHT = new HashTable();

        myHT.set("nails", 100);
        myHT.set("tile", 180);
        myHT.set("lumber", 70);

        myHT.set("bolts", 1100);
        myHT.set("screws", 2100);

        myHT.printTable();

        System.out.println("Get data for nails :: " + myHT.get("nails"));

        System.out.println(myHT.keys());
    }
}
