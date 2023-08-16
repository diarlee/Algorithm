import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = sc.next().split("");
			Stack<String> stack = new Stack<>();
			int piece = 0; // 쇠막대기 조각 개수
			int size = 0; // stack 크기
			for (int i = 0; i < input.length; i++) {
				if (!stack.isEmpty() && input[i].equals(")") && input[i - 1].equals("(")) { // 레이저 발사
					piece--;
					stack.pop();
					piece += stack.size();
				} else if (!stack.isEmpty() && input[i].equals(")") && !input[i - 1].equals("(")) { // 막대기 끝
					stack.pop();
				} else {
					stack.push(input[i]); // 막대기 시작
					piece++;
				}
			}
			System.out.println("#" + test_case + " " + piece);
		}
	}
}