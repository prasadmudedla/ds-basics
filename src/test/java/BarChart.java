import java.util.Arrays;
import java.util.Scanner;
public class BarChart {
    public static void main(String[] args) {

        int arr[] =  {3,2,-2,1,2};
        int len=arr.length;
        int max=0;
        int min=0;
        int outputLength = 0;

        for(int i=0;i<len;i++)   //find max of array
        {
            if (arr[i]>max)
            {
                max=arr[i];
            }
        }

        for(int i=0;i<len;i++)   //find min of array
        {
            if (arr[i]<min)
            {
                min=arr[i];
            }
        }

        if(min<0) {
            outputLength = max - min;
        } else {
            outputLength = max;
        }


        char [][]dis1=new char[len][outputLength];

        for(int j=min;j<len;j++)   //store the array in horizontal order
        {
            for(int i=0;i<max-arr[j];i++) {
                dis1[j][i] = ' ';
            }

            for(int k=max-arr[j];k<max;k++) {
                dis1[j][k]='*';
            }


        }

        for(int i=0;i<max;i++)  //print the array in transpose order
        {
            for(int j=0;j<len;j++)
                System.out.print(dis1[j][i]+" ");
            System.out.println();
        }
    }

}