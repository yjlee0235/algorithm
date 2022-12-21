package Inflearn.p0303;

import java.util.Scanner;

public class Main {

    private int solution(int N, int K, int[] arr) {
        int answer = Integer.MIN_VALUE;
        int tmp = 0;

        for (int i = 0; i < K; i++) {
            tmp += arr[i];
        }
        answer = Math.max(answer, tmp);

        for (int i = K; i < N; i++) {
            tmp -= arr[i - K];
            tmp += arr[i];
            answer = Math.max(answer, tmp);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();
        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }

        System.out.println(T.solution(N, K, input));
    }
}