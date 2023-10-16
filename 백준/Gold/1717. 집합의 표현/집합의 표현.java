import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		p = new int[n + 1];
		for (int i = 0; i < n + 1; i++)
			p[i] = i;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (oper == 0) union(a, b);
			if (oper == 1) {
				if (findSet(a) == findSet(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	
	static void union(int a, int b) {
		if (a < b) p[findSet(b)] = findSet(a);
		else p[findSet(a)] = findSet(b);
	}
	
	static int findSet(int c) {
		if (p[c] != c) p[c] = findSet(p[c]);
		return p[c];
	}
}