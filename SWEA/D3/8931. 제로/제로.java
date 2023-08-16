import java.util.Scanner;
import java.util.Stack;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int K = sc.nextInt();
            Stack<Integer> stack = new Stack<>();
            int size = 0;
            for (int i = 0; i < K; i++) {
                int value = sc.nextInt();
                if (value == 0) { 
                    stack.pop();
                    size--;
                } else {
                    stack.push(value);
                    size++;
                }
            }
            int sum = 0;
            if (size != 0) {
                for (int i = 0; i < size; i++) sum += stack.pop();   
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }
}