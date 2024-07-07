import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Queue{
		int[] q;
		int front = -1;
		int rear = -1;
		
		public Queue(int size) {
			this.q = new int[size];
		}
		
		public void push(int x) {
			q[++rear] = x;
		}
		
		public int pop() {
			if (front == rear) {
				return -1;
			} else {
				return q[++front];
			}
		}
		
		public int size() {
			return rear - front;
		}
		
		public int empty() {
			if (front == rear) {
				return 1;
			} else {
				return 0;
			}
		}
		
		public int front() {
			if (front == rear) {
				return -1;
			} else {
				return q[front + 1];
			}
		}
		
		public int back() {
			if (front == rear) {
				return -1;
			} else {
				return q[rear];
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue queue = new Queue(N);
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			if (oper.equals("push")) {
				queue.push(Integer.parseInt(st.nextToken()));
			} else if (oper.equals("pop")) {
				System.out.println(queue.pop());
			} else if (oper.equals("size")) {
				System.out.println(queue.size());
			} else if (oper.equals("empty")) {
				System.out.println(queue.empty());
			} else if (oper.equals("front")) {
				System.out.println(queue.front());
			} else if (oper.equals("back")) {
				System.out.println(queue.back());
			}
		}
	}
}