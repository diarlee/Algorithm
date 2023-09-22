import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int V1 = Integer.parseInt(st.nextToken());
			int V2 = Integer.parseInt(st.nextToken());
			union(V1, V2);
		}
		for (int i = 1; i <= N; i++) findSet(i);
		
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(p[i]);
		}
		System.out.println(set.size());
	}
	
	static int findSet(int V) {
		if (p[V] == V) return V;
		return p[V] = findSet(p[V]);
	}
	
	static void union(int V1, int V2) {
		if (V1 > V2) p[findSet(V2)] = p[findSet(V1)];
		else p[findSet(V1)] = p[findSet(V2)];
	}
}