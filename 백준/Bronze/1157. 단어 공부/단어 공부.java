import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int[] cnts = new int[26];
		for (int i = 0; i < input.length(); i++) {
			cnts[(input.charAt(i) - 'A') % 32]++;
		}
		int max = -1;
		int maxIdx = -1;
		for (int i = 0; i < 26; i++) {
			if (cnts[i] >= max) {
				max = cnts[i];
				maxIdx = i;
			}
		}
		
		int coCheck = 0;
		for (int i = 0; i < 26; i++) {
			if (cnts[i] == max) {
				coCheck++;
			}
		}
		if (coCheck > 1) System.out.println('?');
		else System.out.println((char)((int)'A' + maxIdx));
	}
}