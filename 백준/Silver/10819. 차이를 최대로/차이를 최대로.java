import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int[] result;
    static int max;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];
        result = new int[N];
        max = 0;
        perm(0);
        System.out.println(max);
    }
    
    static void perm(int level) {
        if (level == N) {
            max = Math.max(max, cal());
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            result[level] = arr[i];
            visited[i] = true;
            perm(level + 1);
            visited[i] = false;
        }
    }
    
    static int cal() {
        int value = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (i == 0) queue.add(result[i]);
            else if (i == N - 1) queue.add(result[i]);
            else {
                queue.add(result[i]);
                queue.add(result[i]);
            }
        }
        while (!queue.isEmpty()) {
            int fir = queue.poll();
            int sec = queue.poll();
            value += Math.abs(fir - sec);
        }
        return value;
    }
}