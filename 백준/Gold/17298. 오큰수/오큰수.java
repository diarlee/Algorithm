import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] results = new int[N];
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) { // 스택으로 반복 횟수 줄이기	
			if (stack.size() != 0 && nums[stack.peek()] < nums[i]) {
				results[stack.pop()] = nums[i];
				while (stack.size() != 0 && nums[stack.peek()] < nums[i]) {
					results[stack.pop()] = nums[i];
				}
			}
			stack.push(i);
		}
		
		while (stack.size() != 0) { // 오큰수 없는 경우
			results[stack.pop()] = -1;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(results[i] + " ");
		}
		bw.write("\n");
		bw.flush();
	}
}