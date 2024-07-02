import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		char curBrack = ' ';
		char preBrack = ' ';
		int cnt = 0;
		for (int i = 0; i < input.length(); i++) {
			preBrack = curBrack;
			curBrack = input.charAt(i);
			if (preBrack == '(' && curBrack == '(') { // 막대기 등록
				cnt++;
			}
			if (curBrack == '(') {
				stack.push(curBrack);
			}
			if (preBrack == ')' && curBrack == ')') { // 막대기 말소
				stack.pop();
			}
			if (preBrack == '(' && curBrack == ')') { // 레이저
				stack.pop();
				cnt += stack.size();
			}
		}
		
		System.out.println(cnt);
	}
}