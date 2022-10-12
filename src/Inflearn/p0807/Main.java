package Inflearn.p0807;

import java.util.Scanner;

public class Main {

    static int[][] memo = new int[34][34];

    private int dfs(int n, int r) {
        if(n < r) {
            return 0;
        }
        if (n == r || r == 0) {
            return 1;
        }
        int left = (memo[n - 1][r - 1] != 0) ? memo[n - 1][r - 1] : dfs(n - 1, r - 1);
        int right = (memo[n - 1][r] != 0) ? memo[n - 1][r] : dfs(n - 1, r);
        return memo[n][r] = left + right;
    }

    private int solution(int n, int r) {
        return dfs(n, r);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();

        System.out.println(T.solution(n, r));
    }
}