import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ItemSeparator {

    private String name;
    private Double price;
    private Integer quantity;

    public ItemSeparator(String rawInput) {
        System.out.println(rawInput);
        String[] str = rawInput.split("\\$\\$##");
        System.out.println(str[0]);
        this.name = str[0];
        this.price = Double.parseDouble(str[1]);
        this.quantity = Integer.parseInt(str[2]);
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

}
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String sub = sc.nextLine();
        ItemSeparator itemData = new ItemSeparator(sub);
        System.out.println("Item Name: " + itemData.getName());
        System.out.println("Item Price: " + itemData.getPrice());
        System.out.println("Item Quantity: " + itemData.getQuantity());
    }
}
