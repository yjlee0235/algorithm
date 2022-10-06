package p0201;

import java.util.Scanner;

public class Main {

    private String solution(int n, int[] input) {
        String answer = input[0] + " ";

        for (int i = 1; i < n; i++) {
            if (input[i - 1] <= input[i]) {
                answer += input[i] + " ";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[] input = new int[101];

        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }

        System.out.println(T.solution(N, input));
    }
}