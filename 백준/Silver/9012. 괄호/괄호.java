import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String input = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < input.length(); i++) {
				char curBrack = input.charAt(i);
				if (curBrack == '(') {
					if (stack.isEmpty()) {
						stack.push(curBrack);
					}
					else if (stack.peek() == curBrack) {
						stack.push(curBrack);
					} else {
						stack.pop();
					}
				}
				if (curBrack == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						stack.push(curBrack);
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			if (stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}