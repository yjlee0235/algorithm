package Inflearn.p0803;

import java.util.Scanner;

public class Main {

    static int[] scores;
    static int[] mins;
    static int maxScore = Integer.MIN_VALUE;

    private void dfs(int L, int timeSum, int scoreSum, int m) {
        if (timeSum > m) {
            return;
        } else if (L == scores.length) {
            maxScore = Math.max(maxScore, scoreSum);
        } else {
            dfs(L + 1, timeSum + mins[L], scoreSum + scores[L], m);
            dfs(L + 1, timeSum, scoreSum, m);
        }
    }

    private int solution(int m) {
        dfs(0, 0, 0, m);
        return maxScore;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int M = kb.nextInt();
        scores = new int[N];
        mins = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = kb.nextInt();
            mins[i] = kb.nextInt();
        }

        System.out.println(T.solution(M));
    }
}