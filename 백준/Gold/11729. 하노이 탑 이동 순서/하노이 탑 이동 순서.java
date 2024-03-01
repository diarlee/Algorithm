import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		bw.write((int)Math.pow(2, N) - 1 + "\n");
		hanoi(N, 1, 2, 3);
		bw.close();
	}
	
	static void hanoi(int N, int from, int mid, int to) throws IOException {
		if (N == 1) {
			bw.write(from + " " + to + "\n");
			return;
		}
		// n - 1개의 위에 있는 원판들을 경유지로 임시로 옮김
		hanoi(N - 1, from, to, mid);
		// n짜리의 가장 큰 원판을 목적지로 옮김
		bw.write(from + " " + to + "\n");
		// n - 1개의 경유지에 있던 원판들을 목적지로 옮김
		hanoi(N - 1, mid, from, to);
	}
}