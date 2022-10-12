package Inflearn.p0906;

import java.util.Scanner;

public class Main {

    static int[] friends;

    private static int find(int x) {
        if (friends[x] == x) {
            return x;
        }
        return friends[x] = find(friends[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            friends[y] = x;
        } else {
            friends[x] = y;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        friends = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            friends[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            union(x, y);
        }

        int x = kb.nextInt();
        int y = kb.nextInt();
        if (find(x) == find(y)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}