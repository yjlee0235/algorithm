package Inflearn.p1001;

import java.util.Scanner;

public class Main {

    static int[] dp;

    private int solution(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int input = kb.nextInt();
        dp = new int[input + 1];

        System.out.println(T.solution(input));
    }
}