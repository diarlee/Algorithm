import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			int i = 1;
			outter : while (queue.peek() - i > 0) {
				while (i <= 5) { // 한 사이클
					if (queue.peek() - i <= 0) break outter; 
					int _tmp = queue.remove();
					queue.add(_tmp - i++);
				}
				i = 1;
			}
			int _tmp2 = queue.remove();
			queue.add(0);
			System.out.print("#" + test_case);
			for (int j = 0; j < 8; j++) System.out.print(" " + queue.remove());
			System.out.println();
		}
	}
}