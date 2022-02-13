import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class LargestSubMatrix {

    static int maxHist(int C, int row[])
    {
        Stack<Integer> result = new Stack<>();

        int top_val;

        int max_area = 0;

        int area = 0;
        int i = 0;
        while (i < C) {
            if (result.empty()
                || row[result.peek()] <= row[i])
                result.push(i++);

            else {
                top_val = row[result.peek()];
                result.pop();
                area = top_val * i;

                if (!result.empty())
                    area
                        = top_val * (i - result.peek() - 1);
                max_area = Math.max(area, max_area);
            }
        }

        while (!result.empty()) {
            top_val = row[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.empty())
                area = top_val * (i - result.peek() - 1);

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }

    static int maxRectangle(int R, int C, int A[][])
    {
        int result = maxHist(C, A[0]);

        for (int i = 1; i < R; i++) {

            for (int j = 0; j < C; j++)

                if (A[i][j] == 1)
                    A[i][j] += A[i - 1][j];

            result = Math.max(result, maxHist(C, A[i]));
        }

        return result;
    }


    public static void main(String[] args) throws IOException
    {

        int R, C;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Row Size :: ");

        R = Integer.parseInt(br.readLine());
        List<String[]> list = new ArrayList<>();

        for(int x=0; x < R; x++) {
            System.out.println("Enter Row " + (x+1) + " using comma between numbers");
            String row= br.readLine();
            String[] StrArr = row.split(",");
            list.add(StrArr);
        }

        C = list.get(0).length;
        int[][] A = new int[R][C];

        for(int i= 0; i < R; i++) {
            String[] row = list.get(0);
            for(int j=0; j < C; j++) {
                A[i][j] = Integer.parseInt(row[i]);
            }
        }

        System.out.print("Area of largest sub-matrix is "
            + maxRectangle(R, C, A));
    }
}
