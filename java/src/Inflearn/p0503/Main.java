package Inflearn.p0503;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    private int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            int top = 0, moveIdx = moves[i] - 1;
            while (top < n && board[top][moveIdx] == 0) {
                top++;
            }
            if (top == n)
                continue;
            if (!stack.isEmpty() && stack.peek() == board[top][moveIdx]) {
                answer += 2;
                stack.pop();
            } else {
                stack.push(board[top][moveIdx]);
            }
            board[top][moveIdx] = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        int M = kb.nextInt();
        int[] moves = new int[M];
        for (int i = 0; i < M; i++) {
            moves[i] = kb.nextInt();
        }

        System.out.println(T.solution(N, board, M, moves));
    }
}