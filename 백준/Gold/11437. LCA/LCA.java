import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] adjList;
	static boolean[] visited;
	static int[] level;
	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjList[n1].add(n2);
			adjList[n2].add(n1);
		}

		visited = new boolean[N + 1];
		level = new int[N + 1];
		p = new int[N + 1];
		getInfos(1, 0);

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			System.out.println(getResult(n1, n2));
		}
	}

	static void getInfos(int curNode, int depth) {
		level[curNode] = depth;
		visited[curNode] = true;
		for (int childNode : adjList[curNode]) {
			if (!visited[childNode]) {
				p[childNode] = curNode;
				getInfos(childNode, depth + 1);
			}
		}
	}

	static int getResult(int n1, int n2) {
		while (level[n1] != level[n2]) {
			if (level[n1] > level[n2]) {
				n1 = p[n1];
			} else {
				n2 = p[n2];
			}
		}
		if (n1 == n2) return n1;
		while (p[n1] != p[n2]) {
			n1 = p[n1];
			n2 = p[n2];
		}
		return p[n1];
	}
}