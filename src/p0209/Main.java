package p0209;

import java.util.Scanner;

public class Main {

    private int solution(int n, int[][] input) {
        int answer = 0, sum = 0;

        // 가로
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum += input[i][j];
            }
            if (sum > answer)
                answer = sum;
        }

        //세로
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum += input[j][i];
            }
            if (sum > answer)
                answer = sum;
        }

        sum = 0;
        //왼-오 대각선
        for (int i = 0, j = 0; i < n && j < n; i++, j++) {
            sum += input[i][j];
        }
        if (sum > answer)
            answer = sum;

        sum = 0;
        //오-왼 대각선
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            sum += input[i][j];
        }
        if (sum > answer)
            answer = sum;

        return answer;
    }

    private int solution2(int n, int[][] input) {
        int answer = 0, sum1 = 0, sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += input[i][j];
                sum2 += input[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += input[i][i];
            sum2 += input[i][n - i - 1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[][] input = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                input[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution2(N, input));
    }
}