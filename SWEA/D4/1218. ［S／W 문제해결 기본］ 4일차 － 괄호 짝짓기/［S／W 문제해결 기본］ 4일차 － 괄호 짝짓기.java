import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			Stack<String> stackL = new Stack<>();
			int N = sc.nextInt();
			String[] input = sc.next().split("");
			int check = 1;
			for (int i = 0; i < N; i++) {
				if (input[i].equals("(") || input[i].equals("[") || input[i].equals("{") || input[i].equals("<")) 
					stackL.push(input[i]); // 왼쪽 괄호 스택 삽입
				if (input[i].equals(")")) {
					if (stackL.isEmpty()) check = 0; // 왼쪽 오른쪽 개수 안맞음 or 왼쪽이 오른쪽 뒤에 나옴
					else if (!stackL.pop().equals("(")) check = 0; // 오른쪽 괄호 왼쪽 괄호 짝이 맞는지
				}
				if (input[i].equals("]")) {
					if (stackL.isEmpty()) check = 0;
					else if (!stackL.pop().equals("[")) check = 0;
				}
				if (input[i].equals("}")) {
					if (stackL.isEmpty()) check = 0;
					else if (!stackL.pop().equals("{")) check = 0;
				}
				if (input[i].equals(">")) {
					if (stackL.isEmpty()) check = 0;
					else if (!stackL.pop().equals("<")) check = 0;
				}
			}
			if (!stackL.isEmpty()) { // 왼쪽 오른쪽 개수 안맞음
				check = 0;
			}
			System.out.println("#" + test_case + " " + check);
		}
	}
}