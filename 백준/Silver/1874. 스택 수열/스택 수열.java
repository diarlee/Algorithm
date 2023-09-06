import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int s = 1;
		char[] list = new char[2 * n];
		int idx = 0;
		String ans = "YES";
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num >= s) {
				while (num >= s) { // 값이 같아질 때까지 push
					stack.push(s++);
					list[idx++] = '+';
				}
				stack.pop(); // 값이 같아졌으므로 pop
				list[idx++] = '-';
			}
			else { // num < s
				if (stack.pop() > num) {
					ans="NO";
					System.out.println(ans);
					break;
				}
				list[idx++] = '-';
			}
		}
		if (ans.equals("YES"))
		for (char c : list) System.out.println(c);
	}
}