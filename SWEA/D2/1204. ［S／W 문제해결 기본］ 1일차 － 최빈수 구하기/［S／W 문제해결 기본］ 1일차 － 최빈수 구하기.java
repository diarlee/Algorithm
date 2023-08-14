import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sc.nextInt();
            int[] count = new int[101];
            for (int i = 0; i < 1000; i++) {
                int key = sc.nextInt();
                count[key]++;
            }
            int max_value = -1;
            int max_idx = 0;
            for (int i = 1; i < 101; i++) {
                if (count[i] >= max_value) {
                    max_value = count[i];
                    max_idx = i;
                }
            }
            System.out.printf("#%d %d\n", test_case, max_idx);
        }
    }
}