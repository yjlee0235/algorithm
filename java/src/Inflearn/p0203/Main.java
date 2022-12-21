package Inflearn.p0203;

import java.util.Scanner;

public class Main {

    private char[] solution(int n, int[] a, int[] b) {
        char[] answer = new char[n];

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                answer[i] = 'D';
            } else if (a[i] == 1) {
                answer[i] = (b[i] == 2) ? 'B' : 'A';
            } else if (a[i] == 2) {
                answer[i] = (b[i] == 1) ? 'A' : 'B';
            } else {
                answer[i] = (b[i] == 1) ? 'B' : 'A';
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = kb.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = kb.nextInt();
        }

        for (char ch : T.solution(N, A, B)) {
            System.out.println(ch);
        }
    }
}