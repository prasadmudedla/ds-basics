package datastructures.hashTableProblems;

import java.util.HashMap;

public class FirstNonRepeatingChar {

    public static Character firstNonRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0 )+1);
        }
        for(char ch: str.toCharArray()) {
            if(map.get(ch)==1) {
                return ch;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */

    }

}
