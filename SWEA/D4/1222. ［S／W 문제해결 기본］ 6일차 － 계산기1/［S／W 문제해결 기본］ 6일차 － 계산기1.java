import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution
{	
	public static boolean isOperator(String str) {
		if (str.equals("(") || str.equals("*") || str.equals("+")) return true;
		return false;
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		Map<String, Integer> mapIn = new HashMap<>(); 
		mapIn.put("(", 0); // 값이 클수롣 우선순위 높음
		mapIn.put("*", 2);
		mapIn.put("+", 1);
		Map<String, Integer> mapOut = new HashMap<>();
		mapOut.put("(", 3); // 값이 클수롣 우선순위 높음
		mapOut.put("*", 2);
		mapOut.put("+", 1);
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			String[] input = sc.next().split("");
			Stack<String> stack = new Stack<>();
			List<String> arr = new ArrayList<>();

			
			// 스택에 연산자를 배열에 피연산자를 담기
			for (int i = 0; i < N; i++) {
				// 연산자이면 스택 top과 비교
				if (isOperator(input[i])) {
					if (stack.isEmpty()) stack.push(input[i]);
					else if (mapOut.get(input[i]) > mapIn.get(stack.peek())) {
						stack.push(input[i]);
					} else {
						while (!stack.isEmpty() && mapIn.get(stack.peek()) >= mapOut.get(input[i])) {
							arr.add(stack.pop());
						}
						stack.push(input[i]);
					}
					
				} else if (input[i].equals(")")) {
					while (!stack.isEmpty() && stack.peek() != "(") {
						arr.add(stack.pop());
					}
				}
				else arr.add(input[i]);
			}
			while (!stack.isEmpty()) arr.add(stack.pop());
			
			for (int i = 0; i < arr.size(); i++) {
				if (isOperator(arr.get(i))) {
					int fir = Integer.parseInt(stack.pop());
					int sec = Integer.parseInt(stack.pop());
					if (arr.get(i).equals("*")) stack.push(Integer.toString(sec * fir));
					if (arr.get(i).equals("+")) stack.push(Integer.toString(sec + fir));
				}
				else stack.push(arr.get(i));
			}
			System.out.println("#" + test_case + " " + stack.pop());
		}
	}
}