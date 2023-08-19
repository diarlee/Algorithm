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
            sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println("#" + test_case + " " + doubleMulti(N, M));
		}
	}
	public static int doubleMulti(int n, int m) {
		if (m == 1) return n;
		return n * doubleMulti(n, m - 1);
	}
}