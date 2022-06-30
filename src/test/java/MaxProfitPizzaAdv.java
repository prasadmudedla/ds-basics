import java.util.Scanner;

public class MaxProfitPizzaAdv {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String[] inputArray1 = input1.split("\\s+");
        int slotPrice = Integer.parseInt(inputArray1[1]);
        String input2 = sc.nextLine();
        String[] inputArray2 = input2.split("\\s+");
        int[] studentCountArray = new int[inputArray2.length];
        for(int index =0; index < studentCountArray.length; index++) {
            studentCountArray[index] = Integer.parseInt(inputArray2[index]);
        }
        int maxProfit = 0;

        for(int i=0; i< studentCountArray.length; i++) {
            int singleSlotProfit = studentCountArray[i] - slotPrice;
            if(singleSlotProfit > maxProfit) {
                maxProfit =  singleSlotProfit;
            }
            int newSale = studentCountArray[i];
            int count =2;
            for(int j = i+1; j < studentCountArray.length; j++) {
                newSale = newSale + studentCountArray[j];
                if((newSale - (count)*slotPrice) > maxProfit) {
                    maxProfit = newSale - (count)*slotPrice;
                }
                count = count+1;
            }
        }
        System.out.println(maxProfit);
    }

}
