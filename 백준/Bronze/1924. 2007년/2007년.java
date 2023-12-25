import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] monthSum = new int[13];
		for (int i = 1; i < 13; i++) {
			monthSum[i] = month[i] + monthSum[i - 1];
		}
		String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int daySum = monthSum[x - 1] + y;
		System.out.println(day[daySum % 7]);
	}
}