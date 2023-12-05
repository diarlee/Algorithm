import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] perm = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			perm[i] = Integer.parseInt(st.nextToken());
		}
		int[] dpL = new int[N + 1]; // dpL[i] : 왼쪽부터 시작해서 i를 포함하며 연속하는 수 중 최대값
		int[] dpR = new int[N + 2]; // dpR[i] : 오른쪽부터 시작해서 i를 포함하며 연속하는 수 중 최대값
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			dpL[i] = Math.max(dpL[i - 1] + perm[i], perm[i]);
			if (max < dpL[i]) max = dpL[i]; // 삭제 안했을 때의 최대값
		}
		for (int i = N; i >= 1; i--) {
			dpR[i] = Math.max(dpR[i + 1] + perm[i], perm[i]);
		}
		for (int i = 1; i <= N; i++) { // dpL[i - 1] + dpR[i + 1] : perm[i]를 삭제했을 때 연속하는 수 중 최대값
			if (max < dpL[i - 1] + dpR[i + 1]) max = dpL[i - 1] + dpR[i + 1];
		}
		if (N == 1) System.out.println(perm[1]);
		else System.out.println(max);
	}
}