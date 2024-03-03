import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int[] nums;
	static int[] pResult;
	static int[] nResult;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] myCards = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			myCards[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		nums = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		pResult = new int[10000001];
		nResult = new int[10000001];
		int[] orig = nums.clone();
		Arrays.sort(nums);
		
		for (int i = 0; i < N; i++) {
			binarySearch(myCards[i]);
		}
		
		for (int i = 0; i < M; i++) {
			if (orig[i] >= 0)
				bw.write(pResult[orig[i]] + " ");
			if (orig[i] < 0)
				bw.write(nResult[Math.abs(orig[i])] + " ");
		}
		bw.close();
	}
	
	static void binarySearch(int num) {
		int left = 0, right = M - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == num) {
				if (num >= 0)
					pResult[num]++;
				if (num < 0)
					nResult[Math.abs(num)]++;
				return;
			}
			else if (nums[mid] < num)
				left = mid + 1;
			else
				right = mid - 1;
		}
	}
}