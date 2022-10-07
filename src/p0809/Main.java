package p0809;

import java.util.Scanner;

public class Main {

    static int[] combi;

    private void dfs(int L, int s, int n, int m) {
        if (L == m) {
            for (int i : combi)
                System.out.print(i + " ");
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                dfs(L + 1, i + 1, n, m);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        combi = new int[m];
        T.dfs(0, 1, n, m);
    }
}