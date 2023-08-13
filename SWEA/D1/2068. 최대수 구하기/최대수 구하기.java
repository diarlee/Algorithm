import java.util.Scanner;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
        int max = Integer.MIN_VALUE;
            int v;
            for (int i = 0; i < 10; i++) { // 한 줄 입력받음
                v = sc.nextInt();
                if (v > max) max = v;
            }
            System.out.printf("#%d %d\n", test_case, max);
        }
    }
}