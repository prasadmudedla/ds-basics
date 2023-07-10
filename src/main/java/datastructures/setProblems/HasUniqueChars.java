package datastructures.setProblems;

import java.util.HashSet;
import java.util.Set;

public class HasUniqueChars {

    public static boolean hasUniqueChars(String str){

        Set<Character> set = new HashSet<>();
        for(char ch: str.toCharArray()) {
            if(set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(hasUniqueChars("abcdefg")); // should return true
        System.out.println(hasUniqueChars("hello")); // should return false
        System.out.println(hasUniqueChars("")); // should return true
        System.out.println(hasUniqueChars("0123456789")); // should return true
        System.out.println(hasUniqueChars("abacadaeaf")); // should return false

        /*
            EXPECTED OUTPUT:
            ----------------
            true
            false
            true
            true
            false

        */

    }
}
