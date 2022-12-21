package Inflearn.p0304;

import java.util.Scanner;

public class Main {

    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        int tmp = 0;
        int start = 0, end = 0;

        while (end < n) {
            while (tmp < m)
                tmp += arr[end++];
            if (tmp == m) {
                answer++;
                if (start <= end && end < n)
                    tmp += arr[end++] - arr[start++];
                else
                    break;
            }
            while (tmp > m)
                tmp -= arr[start++];
            if (tmp == m) {
                answer++;
                if (start <= end && end < n)
                    tmp += arr[end++] - arr[start++];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int M = kb.nextInt();
        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }

        System.out.println(T.solution(N, M, input));
    }
}