import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = sc.next().split("");
		int total = 0;
		for (int i = 0; i < N; i++) {
			total += Integer.parseInt(arr[i]);
		}
		System.out.println(total);
	}
	
	
}
