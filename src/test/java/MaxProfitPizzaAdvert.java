import java.util.Scanner;

public class MaxProfitPizzaAdvert
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String[] inputArray1 = input1.split("\\s+");
        int slotPrice = Integer.parseInt(inputArray1[1]);
        String input2 = sc.nextLine();
        String[] inputArray2 = input2.split("\\s+");
        int[] studentCountArray = new int[inputArray2.length];
        for(int index =0; index < studentCountArray.length; index++) {
            studentCountArray[index] = Integer.parseInt(inputArray2[index]) - slotPrice;
        }

        int maxSoFar = studentCountArray[0], maxEndingHere = studentCountArray[0];

        for (int i = 1; i < studentCountArray.length; i++)
        {
            if (maxEndingHere < 0)
                maxEndingHere = studentCountArray[i];
            else
                maxEndingHere += studentCountArray[i];

            if (maxEndingHere >= maxSoFar)
                maxSoFar = maxEndingHere;
        }
        System.out.println(maxSoFar);
    }

}
