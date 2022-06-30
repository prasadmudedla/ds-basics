import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfInputDigits
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfInputs = input.nextInt();
        List<String> costList = new ArrayList<>();
        for(int index =0; index < numberOfInputs; index++) {
            costList.add(input.next());
        }
        for (String cost: costList)
        {
            System.out.println(cost.length());
        }
    }
}
