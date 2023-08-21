import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	// 내 풀이
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int st = 1, ed = 1;
        int cnt = 1; // 자기자신 포함
        int sum = st;
        while (st <= N / 2) {
        	// st값을 증가시켜가며 st ~ ed값의 합이 N인지 확인
        	ed++;
        	sum += ed;
        	if (sum == N) cnt++;
        	if (sum > N) {
        		st++;
        		ed = st;
        		sum = st;
        	}
        }
        System.out.println(cnt);
    }
}