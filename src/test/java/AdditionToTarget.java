import java.util.ArrayList;
import java.util.List;

public class AdditionToTarget
{

    public static void main(String[] args)
    {
        int[] arr = new int[] {1,2,3,4,5,6,8,-1};
        int target = 7;

        addToTarget(arr, target);
    }

    public static void addToTarget(int[] arr, int target) {
        List<int[]> output = new ArrayList<int[]>();

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target) {
                    System.out.println("combo is " + arr[i] + " :: " + arr[j] );
                }
            }
        }
    }

}
