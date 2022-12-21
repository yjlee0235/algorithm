package Inflearn.p0603;

import java.util.Scanner;

public class Main {

    private String solution(int n, int[] arr) {
        String answer = "";

        int i, j;
        for (i = 1; i < n; i++) {
            int tmp = arr[i];
            for (j = i - 1; j >= 0 && tmp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }

        for (int x : arr) {
            answer += x + " ";
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

        System.out.println(T.solution(N, input));
    }
}