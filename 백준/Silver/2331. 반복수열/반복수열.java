import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int P;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		int[] D = new int[1000000];
		int[] idxs = new int[1000000];
		
		int curNum = A;
		int idx = 0;
		// curNum이 수열에서 몇 번째 수인지 구하면서
		// 반복되는 수가 나올때까지 수열 진행
		while (D[curNum] == 0) {
			idxs[curNum] = idx++;
			int nextNum = getNextNum(curNum);
			D[curNum] = nextNum;
			curNum = nextNum;
		}
		
		// 반복수열의 시작점의 인덱스 == 반복되지 않는 부분의 개수
		System.out.println(idxs[curNum]);
	}
	
	// 수열의 다음 수 구하기
	static int getNextNum(int curNum) {
		List<Integer> list = new ArrayList<>();
		while (curNum > 0) {
			list.add(curNum % 10);
			curNum /= 10;
		}
		int nextNum = 0;
		for (int n : list) {
			nextNum += (int) Math.pow(n, P);
		}
		return nextNum;
	}
}