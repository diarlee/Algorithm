import java.util.*;
import java.io.*;

public class Main {
	static int k;
	static int[] S;
	static int[] lotto;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) break;
			S = new int[k];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			lotto = new int[6];
			dfs(0, -1);
			System.out.println();
		}
	}
	
	static void dfs(int level, int idx) { // level : 현재 결정하려는 자릿수, idx : 이전 level의 자릿수
		if (level == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(lotto[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = idx + 1; i < k + level - 5; i++) {
			lotto[level] = S[i];
			dfs(level + 1, i);
		}
	}
}