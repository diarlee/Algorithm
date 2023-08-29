import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int S = Integer.parseInt(input[0]), P = Integer.parseInt(input[1]);
		String str = br.readLine();
		String[] input2 = br.readLine().split(" ");
		int[] condi = new int[input2.length]; // A C G T
		for (int i = 0; i < input2.length; i++) condi[i] = Integer.parseInt(input2[i]); 
		char[] window = new char[P];
		int[] counts = new int[4];
		for (int i = 0; i < P; i++) { // window index가 str의 0 ~ P - 1에서 시작 
			char letter = str.charAt(i);
			window[i] = letter;
			if (letter == 'A') counts[0]++;
			else if (letter == 'C') counts[1]++;
			else if (letter == 'G') counts[2]++;
			else if (letter == 'T') counts[3]++;
		}
		// window 배열의 요소들은 그대로지만 슬라이드 한다고 상상하여 count만 바뀜
		int idx = 0; // 윈도우 시작위치
		int cnt = 0;
		while (idx + P - 1 < S) { // idx + P - 1: 윈도우 끝위치
			int check = 1;
			for (int i = 0; i < 4; i++) { // 최소 개수 조건 만족하는지
				if (counts[i] - condi[i] < 0) {
					check = 0;
					break;
				}
			}
			if (check == 1) cnt++;
			if (idx + P == S) break;
			// 윈도우 슬라이드
			char removed = str.charAt(idx++);
			if (removed == 'A') counts[0]--;
			else if (removed == 'C') counts[1]--;
			else if (removed == 'G') counts[2]--;
			else if (removed == 'T') counts[3]--;
			char pushed = str.charAt(idx + P - 1);
			if (pushed == 'A') counts[0]++;
			else if (pushed == 'C') counts[1]++;
			else if (pushed == 'G') counts[2]++;
			else if (pushed == 'T') counts[3]++;
		}
		System.out.println(cnt);
	}
}