import java.io.*;
import java.util.*;

public class Main {
	static boolean[] primes;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		primes = new boolean[10000];
		Arrays.fill(primes, true);
		for (int i = 2; i <= 100; i++) {
			for (int j = i; j < 10000; j+=i) {
				primes[j] = false;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10000];
			if (!bfs(from, to)) {
				System.out.println("Impossible");
			}
		}
	}
	
	static boolean bfs(int from, int to) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(from, 0));
		visited[from] = true;
		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			if (curNode.value == to) {
				System.out.println(curNode.cnt);
				return true;
			}
			for (int i = 0; i < 4; i++) {
				int[] figures = new int[4];
				for (int k = 0; k < 4; k++) {
					figures[k] = curNode.figures[k];
				}
				for (int j = 0; j < 10; j++) {
					figures[i] = j;
					int value = toValue(figures);
					if (value >= 1000 && primes[value] && !visited[value]) {
						Node newNode = new Node();
						newNode.value = value;
						for (int k = 0; k < 4; k++) {
							newNode.figures[k] = figures[k];
						}
						newNode.cnt = curNode.cnt + 1;
						queue.add(newNode);
						visited[value] = true;
					}
				}
			}
		}
		return false;
	}
	
	static int toValue(int[] figures) {
		int value = 0;
		int figure = 1000;
		for (int i = 0; i < 4; i++) {
			value += figures[i] * figure;
			figure /= 10;
		}
		return value;
	}
	
	static class Node {
		int value;
		int[] figures = new int[4];
		int cnt;
		
		public Node() {
		};
		
		public Node(int value, int cnt) {
			this.value = value;
			int idx = 3;
			while (value > 0) {
				this.figures[idx--] = value % 10;
				value /= 10;
			}
			this.cnt = cnt;
		}
	}
}