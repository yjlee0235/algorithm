package p1003;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private int solution(int[] arr) {
        int answer = 1;
        int[][] dp = new int[arr.length][2];

        dp[0][0] = arr[0];
        dp[0][1] = 1;
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            for (; j >= 0; j--) {
                if (dp[j][0] < arr[i]) {
                    dp[i][0] = arr[i];
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                    answer = Math.max(answer, dp[i][1]);
                }
            }
            if (dp[i][1] == 0) {
                dp[i][0] = arr[i];
                dp[i][1] = 1;
            }
        }
        return answer;
    }

    private int solution2(int[] arr) {
        int answer = 1;
        int[] dp2 = new int[arr.length];

        Arrays.fill(dp2, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dp2[j] >= dp2[i]) {
                    dp2[i] = dp2[j] + 1;
                    answer = Math.max(answer, dp2[i]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }

        System.out.println(T.solution(input));
    }
}