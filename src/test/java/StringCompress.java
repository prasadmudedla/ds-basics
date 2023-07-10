import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 *
 * Write a method to perform basic string compression using
 * the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3.
 * If the compressed string would not become smaller than
 * the original string, your method should return the
 * original string.
 *
 * You can assume the string has only upper and lower
 * case letters (a-z).
 *
 * More examples:
 * str=aabcccccaaa return a2b1c5a3
 * str=aabbcc return aabbcc
 * str=aaaa return a4
 */

class StringCompress {

    public static void main(String[] args) {
        String s = "aabcccccaaa";
        StringBuilder outStr = new StringBuilder();
        char[] charArray = s.toCharArray();
        char startChar = charArray[0];

        int charCount = 0;

        for(char c: s.toCharArray()) {
            if(startChar == c) {
                charCount++;
            } else {
                outStr.append(String.valueOf(startChar)+charCount);
                startChar = c;
                charCount = 1;
            }
        }
        outStr.append(String.valueOf(startChar)+charCount);

        System.out.println(outStr);

    }
}

