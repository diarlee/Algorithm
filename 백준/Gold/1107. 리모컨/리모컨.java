import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] buttons;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		buttons = new boolean[10];
		Arrays.fill(buttons, true);
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				buttons[Integer.parseInt(st.nextToken())] = false;
			}
		}
		
		if (N == 100) {
			System.out.println(0);
		} else {
			if (M == 10) {
				System.out.println((int) Math.abs(N - 100));
			} else {
				int resultNum = findNearNum(N);
				int result1 = ("" + resultNum).length() + (int) Math.abs(N - resultNum);
				int result2 = (int) Math.abs(N - 100);
				System.out.println(Math.min(result1, result2));
			}
		}
	}
	
	static int findNearNum(int num) {
		if (isPossible(num)) return num;
		int left = num - 1, right = num + 1;
		while (left >= 0 && right <= 1000000) {
			if (isPossible(left)) return left;
			left--;
			
			if (isPossible(right)) return right;
			right++;
		}
		
		while (left >= 0) {
			if (isPossible(left)) return left;
			left--;
		}
		
		while (right <= 1000000) {
			if (isPossible(right)) return right;
			right++;
		}
		return -1;
	}
	
	static boolean isPossible(int num) {
		String st = "" + num;
		for (int i = 0; i < st.length(); i++) {
			if (!buttons[st.charAt(i) - '0'])
				return false;
		}
		return true;
	}
}