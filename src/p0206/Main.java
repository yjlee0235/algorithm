package p0206;

import java.util.Scanner;

public class Main {

    private void solution(int n, String[] input) {
        int[] arr = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            String reversed = new StringBuilder(input[i]).reverse().toString();
            arr[i] = Integer.parseInt(reversed);
            if (max < arr[i])
                max = arr[i];
        }

        int[] prime = new int[max + 1];
        prime[0] = prime[1] = 1;
        for (int i = 2; i <= max; i++) {
            if (prime[i] == 0) {
                for (int j = i * 2; j <= max; j += i) {
                    prime[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (prime[arr[i]] == 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private void solution2(int n, int[] input) {
        int[] arr = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            int tmp = input[i], reversed = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                reversed = reversed * 10 + t;
                tmp /= 10;
            }
            if (max < reversed)
                max = reversed;
            arr[i] = reversed;
        }

        int[] prime = new int[max + 1];
        prime[0] = prime[1] = 1;
        for (int i = 2; i <= max; i++) {
            if (prime[i] == 0) {
                for (int j = i * 2; j <= max; j += i) {
                    prime[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (prime[arr[i]] == 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
//        String[] input = new String[N];
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
//            input[i] = kb.next();
        }

        T.solution2(N, input);
    }
}