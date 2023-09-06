import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 정렬기준 customizing
        // return 양수 : 첫 번재 파라미터(o1) > 두 번째 파라미터(o2)
        // return 0 : 두 수가 같음
        // return 음수 : 첫 번째 파라미터(o1) < 두 번째 파라미터(o2)
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> { 
        	if (Math.abs(o1) > Math.abs(o2)) return 1;  // Math.abs(o1) > Math.abs(o2)인 경우 o1이 더 크다
            if (Math.abs(o1) < Math.abs(o2)) return -1; // Math.abs(o1) < Math.abs(o2)인 경우 o2가 더 크다
            if (o1 == o2) return 0; // 절대값이 같고 부호도 같은 경우 o1과 o2는 같다
            return o1-o2; // 절대값은 같은데 값은 다를 경우 // o1이 양수인경우 o1이 더 크다 // o1이 음수인경우 o2가 더 크다
        });
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            } else {
                pq.offer(x);
            }
        }
    }
}