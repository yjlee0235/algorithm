package Inflearn.p0207;

import java.util.Scanner;

public class Main {

    private int solution(int n, int[] input) {
        int answer = 0, count = 0;

        for (int i = 0; i < n; i++) {
            if (input[i] == 1) {
                answer += ++count;
            } else {
                count = 0;
            }
        }

        return answer;
    }

    private int solution2(int n, int[] input) {
        int answer = 0, count = 0;

        for (int i = 0; i < n; i++) {
            count = (input[i] == 1) ? count + 1 : 0;
            answer += count;
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
        System.out.println(T.solution2(N, input));
    }
}