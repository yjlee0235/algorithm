package Inflearn.p1005;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] coins;
    static int[] dp;

    private int solution(int m) {
        for (int c : coins) {
            dp[c] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int c : coins) {
                if (i + c <= m && (dp[i + c] == 0 || dp[i] + 1 < dp[i + c])) {
                    dp[i + c] = dp[i] + 1;
                }
            }
        }
        return dp[m];
    }

    private int solution2(int m) {
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= m; j++) {
                if (dp[j - coins[i]] < dp[j]) {
                    dp[j] = dp[j - coins[i]] + 1;
                }
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = kb.nextInt();
        }
        int M = kb.nextInt();
        dp = new int[M + 1];

        System.out.println(T.solution2(M));
    }
}