import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int len = N.length();
		
		// 30의 배수 : 3의 배수이면서 일의 자리 수가 0
		int sum = 0;
		int zeroCnt = 0;
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			int num = N.charAt(i) - '0';
			if (num == 0) zeroCnt++;
			arr[i] = num;
			sum += num;
		}
		if (sum % 3 == 0 && zeroCnt > 0) {
			Arrays.sort(arr);
			String result = "";
			for (int i = len - 1; i >= 0; i--) {
				result += arr[i];
			}
			System.out.println(result);
		} else System.out.println(-1);
	}
}