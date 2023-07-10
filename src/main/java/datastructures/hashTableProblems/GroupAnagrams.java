package datastructures.hashTableProblems;

import java.util.*;

import static java.util.Collections.sort;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strArray) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for(String str: strArray) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);

            if(anagramGroups.containsKey(sortedString)) {
                anagramGroups.get(sortedString).add(str);
            } else {
                List<String> group = new ArrayList<>();
                group.add(str);
                anagramGroups.put(sortedString, group);
            }
        }
        return new ArrayList<>(anagramGroups.values());
    }


    public static void main(String[] args) {
        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

        /*
            EXPECTED OUTPUT:
            ----------------
            1st set:
            [[eat, tea, ate], [tan, nat], [bat]]

            2nd set:
            [[abc, cba, bac], [foo], [bar]]

            3rd set:
            [[listen, silent], [triangle, integral], [garden, ranged]]

        */

    }
}
