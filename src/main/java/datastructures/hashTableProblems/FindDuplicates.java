package datastructures.hashTableProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicates {

    public static List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> countOfIntegersMap = new HashMap<>();
        for(int num: nums) {
            countOfIntegersMap.put(num, countOfIntegersMap.getOrDefault(num, 0)+1);
        }

        List<Integer> duplicatesList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry:countOfIntegersMap.entrySet()) {
            if(entry.getValue()>1) {
                duplicatesList.add(entry.getKey());
            }
        }
        return duplicatesList;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);

        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */

    }

}
