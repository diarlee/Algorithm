import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt(), W = sc.nextInt(); // 맵의 높이, 너비
			char[][] arr = new char[H][W];
			for (int i = 0; i < H; i++) {
				arr[i] = sc.next().toCharArray();
			}
			int N = sc.nextInt();
			String input = sc.next();
			for (int i = 0; i < N; i++) {
				char oper = input.charAt(i);
				arr = Action(arr, oper);
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	public static char[][] Action(char[][] arr, char oper) { // 동작 수행  후 바뀐 게임맵 반환
		int H = arr.length;
		int W = arr[0].length;
		int tankH = -1;
		int tankW = -1;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '<' || arr[i][j] == '>') {
					tankH = i;
					tankW = j;
				}
			}
		}
		int[] dr = {-1, 1, 0, 0}; // 상하좌우
		int[] dc = {0, 0, -1, 1}; // 상하좌우		
		if (oper == 'U') {
			arr[tankH][tankW] = '^';
			if (0 <= tankH - 1 && tankH - 1 < H && arr[tankH - 1][tankW] == '.') {
				arr[tankH - 1][tankW] = '^';
				arr[tankH][tankW] = '.';	
			}
		}   
		if (oper == 'D') {
			arr[tankH][tankW] = 'v';
			if (0 <= tankH + 1 && tankH + 1 < H && arr[tankH + 1][tankW] == '.') {
				arr[tankH + 1][tankW] = 'v';
				arr[tankH][tankW] = '.';	
			}
		}   
		if (oper == 'L') {
			arr[tankH][tankW] = '<';
			if (0 <= tankW - 1 && tankW - 1 < W && arr[tankH][tankW - 1] == '.') {
				arr[tankH][tankW - 1] = '<';
				arr[tankH][tankW] = '.';	
			}
		}   
		if (oper == 'R') {
			arr[tankH][tankW] = '>';
			if (0 <= tankW + 1 && tankW + 1 < W && arr[tankH][tankW + 1] == '.') {
				arr[tankH][tankW + 1] = '>';
				arr[tankH][tankW] = '.';	
			}
		}   
		if (oper == 'S') {
			int dir = -1;
			if (arr[tankH][tankW] == '^') dir = 0;
			else if (arr[tankH][tankW] == 'v') dir = 1;
			else if (arr[tankH][tankW] == '<') dir = 2;
			else if (arr[tankH][tankW] == '>') dir = 3;
			int bombH = tankH;
			int bombW = tankW;
			while (0 <= bombH + dr[dir] && bombH + dr[dir] < H && 0 <= bombW + dc[dir] && bombW + dc[dir] < W) {
				bombH += dr[dir];
				bombW += dc[dir];
				if (arr[bombH][bombW] == '*') {
					arr[bombH][bombW] = '.';
					break;
				}
				else if (arr[bombH][bombW] == '#') break;
			}
		}
		return arr;
	}
}