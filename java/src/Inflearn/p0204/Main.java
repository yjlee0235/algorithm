package Inflearn.p0204;

import java.util.Scanner;

public class Main {

    private int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = answer[1] = 1;

        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        for (int i : T.solution(N)) {
            System.out.print(i + " ");
        }
    }
}