import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] arr = new int[1000000];
		for (int i = 0; i < 1000000; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] sorted = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, sorted);
		System.out.println(arr[500000]);
	}
	
	public static void mergeSort(int[] arr, int left, int right, int[] sorted) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid, sorted); // 분할 왼쪽
			mergeSort(arr, mid + 1, right, sorted); // 분할 오른쪽
			merge(arr, left, mid, right, sorted); // 병합
		}
	}
	
	public static void merge(int[] arr, int left, int mid, int right, int[] sorted) {
		// 인덱스 left ~ right까지 합쳐서 정렬
		int L = left, R = mid + 1;
		int idx = left;
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) { // 왼쪽 오른쪽 두  부분집합의 젤 앞의 원소부터 비교
				sorted[idx++] = arr[L++]; // 왼쪽의 원소 삽입 
			} else {
				sorted[idx++] = arr[R++]; // 오른쪽의 원소 삽입
			}
		} // idx번째까지 정렬됨
		if (L <= mid) { // 왼쪽 부분집합의 원소가 남은 경우
			for (int i = L; i <= mid; i++) {
				sorted[idx++] = arr[i];
			}
		}
		if (R <= right) { // 오른쪽 부분집합의 원소가 남은 경우
			for (int j = R; j <= right; j++) {
				sorted[idx++] = arr[j];
			}
		}
		for (int k = left; k <= right; k++) arr[k] = sorted[k];
	}
}