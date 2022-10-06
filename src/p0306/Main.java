package p0306;

import java.util.Scanner;

public class Main {

    private int solution1(int n, int k, int[] arr) {
        int answer = 0;
        int change = 0;
        int tmp = 0, lt = 0;

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 1) {
                tmp++;
            } else {
                if (change < k) {
                    change++;
                    tmp++;
                } else {
                    while (arr[lt] == 1) {
                        tmp--;
                        lt++;
                    }
                    lt++;
                }
            }
            answer = Math.max(answer, tmp);
        }
        return answer;
    }

    private int solution2(int n, int k, int[] arr) {
        int answer = 0;
        int change = 0, lt = 0;

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                if (change < k) {
                    change++;
                } else {
                    while (arr[lt] == 1) {
                        lt++;
                    }
                    lt++;
                }
            }
            answer = Math.max(answer, rt - lt + 1);
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

        System.out.println(T.solution2(N, K, input));
    }
}