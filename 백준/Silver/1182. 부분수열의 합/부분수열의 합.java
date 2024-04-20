import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int S;
	static int[] arr;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		recur(0, 0);
		if (S == 0) cnt--;
		System.out.println(cnt);
	}
	
	static void recur(int level, int sum) {
		if (level == N && sum == S) {
			cnt++;
			return;
		}
		if (level == N) return;
		
		recur(level + 1, sum + arr[level]);
		
		recur(level + 1, sum);
	}
}