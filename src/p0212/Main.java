package p0212;

import java.util.Scanner;

public class Main {

    private int solution(int n, int m, int[][] input) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int pi = Integer.MAX_VALUE;
                    for (int s = 0; s < n; s++) {
                        if (input[k][s] == i) {
                            pi = s;
                        }
                        if (input[k][s] == j) {
                            if (pi < s) {
                                cnt++;
                            }
                            break;
                        }
                    }
                }
                if (cnt == m) {
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
        int M = kb.nextInt();
        int[][] input = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                input[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution(N, M, input));
    }
}