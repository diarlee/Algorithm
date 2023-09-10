import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(str.substring(i, i + 1));
		// str.substring(start, end) : 문자열의 start부터 end 전까지를 잘라서 return
		int maxIdx;
		for (int i = 0; i < N - 1; i++) {
			maxIdx = i;
			for (int j = i; j < N; j++) {
				if (arr[j] > arr[maxIdx]) maxIdx = j;
			}
			int tmp = arr[i];
			arr[i] = arr[maxIdx];
			arr[maxIdx] = tmp;
		}
		String result = "";
		for (int i = 0; i < N; i++) {
			result += String.valueOf(arr[i]);
		}
		System.out.println(result);
	}
}