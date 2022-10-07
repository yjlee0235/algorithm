package p0808;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    static int[] result;
    static boolean[] ch;
    static boolean flag = false;

    static int[][] dp = new int[11][11];
    static int[] b;

    private boolean isRight(int f) {
        Deque<Integer> Q = new ArrayDeque<>();
        for (int i : result) {
            if (i != 0) {
                Q.offer(i);
            }
        }

        while (Q.size() != 1) {
            int size = Q.size();
            for (int i = 0; i < size - 1; i++) {
                int first = Q.poll();
                int second = Q.peekFirst();
                Q.offer(first + second);
            }
            Q.poll();
        }
        return (Q.poll() == f);
    }

    // solution1용 dfs
    private void dfs(int L, int n, int f) {
        if (flag || L == n) {
            if (isRight(f)) {
                flag = true;
                return;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!ch[i]) {
                    result[L] = i;
                    ch[i] = true;
                    dfs(L + 1, n, f);
                    if (flag)
                        return;
                    result[L] = 0;
                    ch[i] = false;
                }
            }
        }
    }

    // solution2용 dfs
    private void dfs(int L, int n, int f, int sum) {
        if (flag)
            return;
        if (L == n) {
            if (sum == f) {
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    result[L] = i;
                    dfs(L + 1, n, f, sum + (result[L] * b[L]));
                    if (flag)
                        return;
                    ch[i] = false;
                }
            }
        }
    }

    private int combi(int n, int r) {
        if (dp[n][r] != 0)
            return dp[n][r];
        if (n == r || r == 0) {
            return 1;
        }
        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    private String solution(int n, int f) {
        String answer = "";
        dfs(0, n, f);
        for (int i : result) {
            answer += i + " ";
        }
        return answer;
    }

    private String solution2(int n, int f) {
        String answer = "";
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = combi(n - 1, i);
        }

        dfs(0, n, f, 0);
        for (int i : result) {
            answer += i + " ";
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int F = kb.nextInt();
        result = new int[N];
        ch = new boolean[N + 1];

        System.out.println(T.solution2(N, F));
    }
}