import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	static int p[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] adjArr = new int[N + 1][N + 1];
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			String tmp = br.readLine();
			for (int j = 1; j <= N; j++) {
				if (tmp.charAt(j - 1) == '0')
					adjArr[i][j] = 0;
				else if (tmp.charAt(j - 1) - 'a' < 0)  { // 대문자
					int len = tmp.charAt(j - 1) - 'A' + 27;
					adjArr[i][j] = len;
					sum += len;
				}
				else  { // 소문자
					int len = tmp.charAt(j - 1) - 'a' + 1;
					adjArr[i][j] = len;
					sum += len;
				}
			}
		}
		
		// 간선 배열 만들기
		List<Edge> edges = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				if (adjArr[i][j] == 0 && adjArr[j][i] == 0) continue;
				if (adjArr[i][j] == 0) {
					edges.add(new Edge(j, i, adjArr[j][i]));
					adjArr[i][j] = adjArr[j][i] = 0;
					continue;
				}
				if (adjArr[j][i] == 0) {
					edges.add(new Edge(i, j, adjArr[i][j]));
					adjArr[i][j] = adjArr[j][i] = 0;
					continue;
				}
				if (adjArr[i][j] < adjArr[j][i]) {
					edges.add(new Edge(i, j, adjArr[i][j]));
					adjArr[i][j] = adjArr[j][i] = 0;
					continue;
				}
				if (adjArr[i][j] >= adjArr[j][i]) {
					edges.add(new Edge(j, i, adjArr[j][i]));
					adjArr[i][j] = adjArr[j][i] = 0;
					continue;
				}
			}
		}
		
		// 간선을 오름차순으로 정렬
		edges.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.w - o2.w;
			}
		});
		
		// 사이클이 발생 안하도록 N-1개의 간선 뽑기
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		int min = 0;
		int pick = 0;
		for (int i = 0; i < edges.size(); i++) {
			Edge e = edges.get(i);
			int x = e.st;
			int y = e.ed;
			
			if (findSet(x) != findSet(y)) {
				union(x, y);
				min += e.w;
				pick++;
			}
			
			if (pick == N - 1) break;
		}
		
		if (pick != N - 1)
			System.out.println(-1);
		else
			System.out.println(sum - min);
	}
	
	static int findSet(int x) {
		if (p[x] == x)
			return x;
		return p[x] = findSet(p[x]);
	}
	
	static void union(int x, int y) {
		if (x < y) 
			p[findSet(y)] = findSet(x);
		else
			p[findSet(x)] = findSet(y);
	}
}

class Edge {
	
	int st;
	int ed;
	int w;
	
	public Edge(int st, int ed, int w) {
		super();
		this.st = st;
		this.ed = ed;
		this.w = w;
	}
}