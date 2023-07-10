package datastructures.setProblems;

import java.util.*;

public class FindPairs {

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        List<int[]> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int value: arr1) {
            set.add(target-value);
        }
        for(int value1: arr2) {
            if(set.contains(value1)) {
                list.add(new int[] {target-value1, value1});
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        /*
            EXPECTED OUTPUT:
            ----------------
            [5, 2]
            [3, 4]
            [1, 6]

        */

    }

}
