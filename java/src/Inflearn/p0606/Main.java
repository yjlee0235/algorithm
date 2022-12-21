package Inflearn.p0606;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private String solution(int n, int[] arr) {
        int[] tmp = new int[n];
        int chulsu = -1, friend = -1;

        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i];
        }

        Arrays.sort(tmp);

        for (int i = 0; i < n; i++) {
            if (tmp[i] != arr[i]) {
                if (chulsu == -1) {
                    chulsu = i + 1;
                } else {
                    friend = i + 1;
                }
            }
        }

        return chulsu + " " + friend;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }

        System.out.println(T.solution(N, input));
    }
}