import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int[] letters = new int[26];
		for (int i = 0; i < S.length(); i++) {
			letters[S.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < 26; i++) {
			System.out.print(letters[i] + " ");
		}
	}
}