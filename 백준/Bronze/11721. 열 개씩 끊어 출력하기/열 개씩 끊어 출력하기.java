import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			if (i != 0 && i % 10 == 0) {
				System.out.println(result);
				result = "";
			}
			result += input.charAt(i);
		}
		System.out.println(result);
	}
}