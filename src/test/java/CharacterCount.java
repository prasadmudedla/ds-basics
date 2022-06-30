public class CharacterCount
{

    public static void main(String[] args)
    {
        String x = "Siddharth";

        char[] ch = x.toCharArray();
        int letter = 0;
        int space = 0;
        int num = 0;
        int other = 0;
        for (int i = 0; i < x.length(); i++)
        {
            if (Character.isLetter(ch[i]))
            {
                letter++;
            }
            else if (Character.isDigit(ch[i]))
            {
                num++;
            }
        }

    }
}
