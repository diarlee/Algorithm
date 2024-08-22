import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int[] cnts = new int[26];
		Arrays.fill(cnts, 100);
		for (int i = 0; i < s.length(); i++) {
			cnts[s.charAt(i) - 'a'] = Math.min(cnts[s.charAt(i) - 'a'], i);
		}
		
		for (int i = 0; i < 26; i++) {
			if (cnts[i] == 100) System.out.print(-1 + " ");
			else System.out.print(cnts[i] + " ");
		}
	}
}