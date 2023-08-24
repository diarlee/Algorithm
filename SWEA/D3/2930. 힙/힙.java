import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // 연산 개수
            System.out.print("#" + t);
            int[] heap = new int[100000];
            int heapSize = 0;
            for (int i = 0; i < N; i++) {
                int oper = sc.nextInt();
                if (oper == 1) { // heapPush
                    heap[++heapSize] = sc.nextInt(); // 마지막 자리에 삽입
                    int ch = heapSize; // 자식
                    int p = ch / 2; // 부모
                    while (p > 0 && heap[ch] > heap[p]) { // 자식이 부모보다 크면 swap
                        int _tmp = heap[p];
                        heap[p] = heap[ch];
                        heap[ch] = _tmp;
                        // 부모 자식을 한 레벨 위로
                        ch = p;
                        p = ch / 2;
                    }
                }
                if (oper == 2) { // heapPop
                    if (heapSize <= 0) {
                    	System.out.print(" " + -1);
                    	continue;
                    }
                    int item = heap[1]; // 루트노드
                    heap[1] = heap[heapSize--]; // 마지막 값을 루트로 이동
                    int p = 1; // 부모
                    int ch = p * 2; // 왼쪽 자식
                    if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) // 오른쪽 자식이 있고 그 값이 왼쪽 자식보다 크다면
                        ch += 1; // 오른쪽 자식으로 설정
                    while (ch <= heapSize && heap[p] < heap[ch]) { // 부모가 자식보다 작다면
                        int _tmp = heap[p];
                        heap[p] = heap[ch];
                        heap[ch] = _tmp;
                        // 부모 자식을 한 단계 아래로
                        p = ch;
                        ch = p * 2; // 왼쪽 자식
                        if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) // 오른쪽 자식이 있고 그 값이 왼쪽 자식보다 크다면
                            ch += 1; // 오른쪽 자식으로 설정
                    }
                    System.out.print(" " + item);
                }
            }
            System.out.println();
        }
    }
}