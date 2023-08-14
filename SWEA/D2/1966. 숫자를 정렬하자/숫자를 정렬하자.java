import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) 
                nums[i] = sc.nextInt();
            Arrays.sort(nums);
            System.out.printf("#%d", test_case);
            for (int n : nums) System.out.print(" " + n);
            System.out.println();
        }
    }
}