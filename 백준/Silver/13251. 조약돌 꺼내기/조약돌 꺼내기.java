import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        double[] colors = new double[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        double N = 0;
        for (int i = 0; i < M; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
            N += colors[i];
        }
        int K = Integer.parseInt(br.readLine());
        double result = 0;
        for (int i = 0; i < M; i++) {
        	double tmp = 1;
        	for (int j = 0; j < K; j++) {
        		tmp *= (colors[i] - j) / (N - j);
        	}
        	result += tmp;
        }
        System.out.println(result);
    }
}