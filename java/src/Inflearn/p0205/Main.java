package Inflearn.p0205;

import java.util.Scanner;

public class Main {

    // fail - timeout
    private int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 2;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j + 2 == i && arr[j] != 0) {
                    answer++;
                } else if ((j + 2) % i == 0) {
                    arr[j] = 0;
                }
            }
        }

        return answer;
    }

    private int solution2(int n) {
        int[] arr = new int[n + 1];
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                answer++;
                for (int j = i; j <= n; j += i) {
                    arr[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        System.out.println(T.solution2(N));
    }
}