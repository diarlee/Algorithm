import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] sorted = new int[N];
		mergeSort(arr, 0, N - 1, sorted);
		for (int i = 0; i < N; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void mergeSort(int[] arr, int left, int right, int[] sorted) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid, sorted); // 왼쪽 부분집합
			mergeSort(arr, mid + 1, right, sorted); // 오른쪽 부분집합
			merge(arr, left, mid, right, sorted);
		}
	}
	
	public static void merge(int[] arr, int left, int mid, int right, int[] sorted) {
		int L = left, R = mid + 1;
		int idx = left;
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				sorted[idx++] = arr[L++];
			} else {
				sorted[idx++] = arr[R++];
			}
		}
		
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				sorted[idx++] = arr[i];
			}
		}
		
		if (R <= right) {
			for (int i = R; i <= right; i++) {
				sorted[idx++] = arr[i];
			}
		}
		
		for (int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}
	
}