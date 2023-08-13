import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] scores = new double[N];
		double M = 0;
		for (int i = 0; i < N; i++) {
			scores[i] = sc.nextInt();
			if (scores[i] > M) M = scores[i];
		}
		double total = 0;
		for (int i = 0; i < N; i++) {
			scores[i] = scores[i] / M * 100;
			total += scores[i];
		}

		System.out.println(total / N);
		
	}
	
	
}
