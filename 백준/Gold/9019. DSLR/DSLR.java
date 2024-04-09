import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10000];
			bfs(A, B);
		}
	}
	
	static void bfs(int A, int B) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(A, ""));
		visited[A] = true;
		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			if (curNode.val == B) {
				System.out.println(curNode.registers);
				return;
			}
			int val = curNode.val;
			int D = val * 2 > 9999 ? val * 2 % 10000 : val * 2;
			if (!visited[D]) {
				queue.add(new Node(D, curNode.registers + "D"));
				visited[D] = true;
			}
			int S = val == 0 ? 9999 : val - 1;
			if (!visited[S]) {
				queue.add(new Node(S, curNode.registers + "S"));
				visited[S] = true;
			}
			int L = orderL(val);
			if (!visited[L]) {
				queue.add(new Node(L, curNode.registers + "L"));
				visited[L] = true;
			}
			int R = orderR(val);
			if (!visited[R]) {
				queue.add(new Node(R, curNode.registers + "R"));
				visited[R] = true;
			}
		}
	}
	
	static int orderL(int val) {
		int[] figures = new int[4];
		for (int i = 3; i >= 0; i--) {
			figures[i] = val % 10;
			val /= 10;
		}
		int tmp = figures[0];
		for (int i = 0; i < 3; i++) {
			figures[i] = figures[i + 1];
		}
		figures[3] = tmp;
		int newVal = 0;
		for (int i = 3; i >= 0; i--) {
			newVal += (int) Math.pow(10, 3 - i) * figures[i];
		}
		return newVal;
	}
	
	static int orderR(int val) {
		int[] figures = new int[4];
		for (int i = 3; i >= 0; i--) {
			figures[i] = val % 10;
			val /= 10;
		}
		int tmp = figures[3];
		for (int i = 3; i >= 1; i--) {
			figures[i] = figures[i - 1];
		}
		figures[0] = tmp;
		int newVal = 0;
		for (int i = 3; i >= 0; i--) {
			newVal += (int) Math.pow(10, 3 - i) * figures[i];
		}
		return newVal;

	}
	
	static class Node{
		int val;
		String registers;
	
		public Node(int val, String registers) {
			this.val = val;
			this.registers = registers;
		}
	}
}