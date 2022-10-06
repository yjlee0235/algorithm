package p0210;

import java.util.Scanner;

public class Main {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    private int solution(int n, int[][] input) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (input[i][j - 1] < input[i][j] &&
                        input[i][j + 1] < input[i][j] &&
                        input[i - 1][j] < input[i][j] &&
                        input[i + 1][j] < input[i][j]) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private int solution2(int n, int[][] input) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && input[nx][ny] >= input[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
//        int[][] input = new int[N + 2][N + 2];
//
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                input[i][j] = kb.nextInt();
//            }
//        }

        int[][] input = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                input[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution2(N, input));
    }
}