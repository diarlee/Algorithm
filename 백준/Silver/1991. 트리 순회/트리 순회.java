import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[] parents;
	static char[] lchildren;
	static char[] rchildren;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parents = new char[N + 1];
		lchildren = new char[N + 1];
		rchildren = new char[N + 1];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char p = st.nextToken().charAt(0);
			parents[p - 'A' + 1] = p;
			char lch = st.nextToken().charAt(0);
			if (lch != '.') lchildren[p - 'A' + 1] = lch;
			char rch = st.nextToken().charAt(0);
			if (rch != '.') rchildren[p - 'A' + 1] = rch;
		}
		preOrder(1);
		System.out.println();
		inOrder(1);
		System.out.println();
		postOrder(1);
	}
	
	static void preOrder(int idx) {
		if (idx > N) return;
		System.out.print(parents[idx]);
		if (lchildren[idx] != '\u0000') preOrder(lchildren[idx] - 'A' + 1);
		if (rchildren[idx] != '\u0000') preOrder(rchildren[idx] - 'A' + 1);
	}
	
	static void inOrder(int idx) {
		if (idx > N) return;
		if (lchildren[idx] != '\u0000') inOrder(lchildren[idx] - 'A' + 1);
		System.out.print(parents[idx]);
		if (rchildren[idx] != '\u0000') inOrder(rchildren[idx] - 'A' + 1);
	}
	
	static void postOrder(int idx) {
		if (idx > N) return;
		if (lchildren[idx] != '\u0000') postOrder(lchildren[idx] - 'A' + 1);
		if (rchildren[idx] != '\u0000') postOrder(rchildren[idx] - 'A' + 1);
		System.out.print(parents[idx]);
	}
}
