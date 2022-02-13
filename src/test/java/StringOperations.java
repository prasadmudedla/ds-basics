import java.util.Arrays;
import java.util.stream.Collectors;

public class StringOperations
{

    public static void main(String[] args)
    {
        String s = "1,2,34,46:42";

        String[] str = s.split(",");
        Arrays.stream(str).map(s1 -> s1.split(":" )).collect(Collectors.toList());

    }

}
