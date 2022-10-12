package Inflearn.p1006;

import java.util.Scanner;

class Problem {
    public int score;
    public int time;

    public Problem(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class Main {

    static Problem[] problems;
    static int[] dp;

    private int solution(int m) {
        for (int i = 0; i < problems.length; i++) {
            Problem tmp = problems[i];
            for (int j = m; j >= tmp.time; j--) {
                if (dp[j - tmp.time] + tmp.score > dp[j]) {
                    dp[j] = dp[j - tmp.time] + tmp.score;
                }
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int M = kb.nextInt();
        problems = new Problem[N];
        dp = new int[M + 1];
        for (int i = 0; i < N; i++) {
            int score = kb.nextInt();
            int time = kb.nextInt();
            problems[i] = new Problem(score, time);
        }

        System.out.println(T.solution(M));
    }
}