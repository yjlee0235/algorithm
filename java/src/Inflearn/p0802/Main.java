package Inflearn.p0802;

import java.util.Scanner;

public class Main {

    static int max = Integer.MIN_VALUE;

    private void DFS(int L, int weight, int c, int[] arr) {
        if (weight > c) {
            return;
        }
        if (L == arr.length) {
            max = Math.max(max, weight);
        } else {
            DFS(L + 1, weight + arr[L], c, arr);
            DFS(L + 1, weight, c, arr);
        }
    }

    private int solution(int c, int n, int[] arr) {
        DFS(0, 0, c, arr);
        return max;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int C = kb.nextInt();
        int N = kb.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }

        System.out.println(T.solution(C, N, input));
    }
}