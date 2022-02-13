import java.util.Scanner;

public class ReplaceSpace
{
    static final int ASCII_SIZE = 256;
    static String findAndReplaceSpecialIndexChar(String str)
    {

        int charCount[] = new int[ASCII_SIZE];
        int numCount[] = new int[10];


        int len = str.length();
        for (int i=0; i<len; i++){
            Boolean flag = Character.isDigit(str.charAt(i));
            if(!flag){
                charCount[str.charAt(i)]++;
            }
            else {
                int num = Character.getNumericValue(str.charAt(i));
                numCount[num]++;
            }
        }


        int charMax = -1;
        char result = ' ';

        for (int i = 0; i < len; i++) {
            if (charMax < charCount[str.charAt(i)]) {
                charMax = charCount[str.charAt(i)];
                result = str.charAt(i);
            }
        }

        int numMax = 0;
        for (int i = 0; i < len; i++) {
            Boolean flag = Character.isDigit(str.charAt(i));
            int num = Character.getNumericValue(str.charAt(i));
            if (flag && numMax < numCount[num]) {
                numMax = numCount[num];
            }
        }

        int specialIndex = Math.abs(charMax - numMax);
        char specialIndexChar = str.charAt(specialIndex);
        String replacedString = str;
        if(specialIndexChar != ' ') {
            replacedString = str.replace(specialIndexChar,' ');
        }
        replacedString = replacedString.replaceAll("\\s{2,}", " ");
        replacedString = replacedString.replace(' ','$');

        return replacedString;
    }

    // Driver Method
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("find And Replace Special Index Char " +
            findAndReplaceSpecialIndexChar(str));
    }
}
