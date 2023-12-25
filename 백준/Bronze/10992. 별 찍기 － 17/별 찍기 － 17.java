import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			if (i != N) {
				for (int j = 0; j < N - i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2 * i - 1; j++) {
					if (j == 0 || j == 2 * i - 2) System.out.print('*');
					else System.out.print(" ");
				}
			}
			if (i == N) {
				for (int j = 0; j < 2 * i - 1; j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}