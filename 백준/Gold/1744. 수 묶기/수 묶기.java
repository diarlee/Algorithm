import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int mCnt = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] <= 0) mCnt++;
		}
		int pCnt = N - mCnt;
		int[] mArr = new int[mCnt];
		int[] pArr = new int[pCnt];
		int mIdx = -1;
		int pIdx = -1;
		for (int i = 0; i < N; i++) {
			if (arr[i] <= 0) mArr[++mIdx] = arr[i];
			else pArr[++pIdx] = arr[i];
		}
		Arrays.sort(mArr);
		Arrays.sort(pArr);
		int sum = 0;
		int i = 0;
		while (i < mIdx) {
			sum += mArr[i] * mArr[i + 1];
			i += 2;
		}
		if (mCnt % 2 == 1) {
			sum += mArr[mIdx];
		}
		int j = pIdx;
		while (j > 0) {
			if (pArr[j] == 1 || pArr[j - 1] == 1) {
				sum += (pArr[j] + pArr[j - 1]);
			} else {
				sum += pArr[j] * pArr[j - 1];
			}
			j -= 2;
		}
		if (pCnt % 2 == 1) {
			sum += pArr[0];
		}
		System.out.println(sum);
	}
}