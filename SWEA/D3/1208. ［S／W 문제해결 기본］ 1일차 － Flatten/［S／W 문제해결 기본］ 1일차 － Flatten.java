import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();       
            int[] boxes = new int[100];
            for (int i = 0; i < 100; i++) 
                boxes[i] = sc.nextInt();
            for (int j = 0; j < N; j++) dump(boxes);
            System.out.printf("#%d %d\n", test_case, dump(boxes));
             
        }
         
    }
     
    public static int dump(int[] arr) {
        int max_value = Integer.MIN_VALUE;
        int max_idx = -1;
        int min_value = Integer.MAX_VALUE;
        int min_idx = -1;
         
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max_value) {
                max_value = arr[i];
                max_idx = i;
            }
            if (arr[i] < min_value) {
                min_value = arr[i];
                min_idx = i;
            }
        }
        arr[max_idx]--;
        arr[min_idx]++;
        return max_value - min_value;
    }
}