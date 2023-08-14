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
			String[] arr = sc.next().split("");
			int N = arr.length;
			int check = 1;
			for (int i = 0; i < arr.length / 2; i++) {
				if (!(arr[i].equals(arr[N - 1 - i]))) {
					check = 0;
					break;
				}
			}
			if (check == 0) System.out.println("#" + test_case + " " + check);
			else System.out.println("#" + test_case + " " + check);
		}
	}
}