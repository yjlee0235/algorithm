package Inflearn.p0602;

import java.util.Scanner;

public class Main {

    private String solution(int n, int[] arr) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int tmp;
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for (int i : arr) {
            answer += i + " ";
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