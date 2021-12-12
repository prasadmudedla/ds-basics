import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddUptoTarget {

    public static void main(String[] args) {
        int[] in = new int[] {1,2,4,5,6};
        int[] inMulti = new int[] {2,7,11,15,1,4,5,6};
        int target = 9;
        addUptoTarget(in, target);
        addUptoTargetMultiple(inMulti,target);
    }

    private static void addUptoTargetMultiple(int[] in, int target) {
        List<int[]> out = new ArrayList<int[]>();
        for(int index1=0; index1 < in.length-1; index1++) {
            for(int index2= index1+1; index2< in.length; index2++) {
                int[] combo = new int[2];
                if(in[index1] + in[index2] == target) {
                    combo[0] = index1;
                    combo[1] = index2;
                    out.add(combo);
                }
            }
        }

        for ( int[] combo: out ) {
            System.out.println(Arrays.toString(combo));
        }
    }

    private static void addUptoTarget(int[] in, int target) {
        int[] combo = new int[2];
        for(int index1=0; index1 < in.length-1; index1++) {
            for(int index2= index1+1; index2< in.length; index2++) {
                if(in[index1] + in[index2] == target) {
                    combo[0] = index1;
                    combo[1] = index2;
                    break;
                }
            }
        }
        System.out.print(Arrays.toString(combo));
    }

}
