import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static long[] cases;
	static boolean[] visited;
	static int[] result;
	static int mission;
	static long cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		cases = new long[N];
		cases[N - 1] = 1;
		for (int i = 2; i <= N; i++) {
			cases[N - i] = cases[N - i + 1] * i;
		}
		visited = new boolean[N];
		result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		mission = Integer.parseInt(st.nextToken());
		if (mission == 1) {
			long K = Long.parseLong(st.nextToken());
			perm1(K, 0);
		}
		if (mission == 2) {
			int[] target = new int[N];
			for (int i = 0; i < N; i++) {
				target[i] = Integer.parseInt(st.nextToken());
			}
			perm2(target, 0);
		}

	}
	
	static void perm1(long K, int level) { // level 자릿수
		if (level == N - 1) {
			for (int i = 0; i < N; i++) {
				if (!visited[i]) result[level] = arr[i];
			}
			for (int i = 0; i < N; i++) {
				System.out.print(result[i] + " ");
			}
			return;
		}
		int group = 0; // 각 자릿수에서 몇 번째 그룹인지
		while (K > cases[level + 1]) { // 몇 번째 그룹인지 계산
			K -= cases[level + 1];
			group++;
		}
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if (idx == group && !visited[i]) {
				result[level] = arr[i];
				visited[i] = true;
				break;
			}
			if (!visited[i]) idx++;
		}
		perm1(K, level + 1);
	}
	
	static void perm2(int[] target, int level) { // level : 자릿수
		if (level == N - 1) {
			cnt += 1;
			System.out.println(cnt);
			return;
		}
		
		int group = 0; // 각 자릿수에서 몇 번째 그룹인지
		for (int i = 0; i < N; i++) {
			if (arr[i] == target[level]) {
				cnt += cases[level + 1] * group;
				visited[i] = true;
				break;
			}
			if (!visited[i]) group++;
		}
		perm2(target, level + 1);
	}
}