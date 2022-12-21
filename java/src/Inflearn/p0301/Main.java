package Inflearn.p0301;

import java.util.Scanner;

public class Main {

    private String solution(int[] first, int[] second) {
        int totalLen = first.length + second.length;
        int[] tmp = new int[totalLen];
        String answer = "";
        int fidx = 0, sidx = 0, i = 0;

        while (fidx < first.length && sidx < second.length) {
            if (first[fidx] < second[sidx]) {
                tmp[i++] = first[fidx++];
            } else if (first[fidx] == second[sidx]) {
                tmp[i++] = first[fidx++];
                tmp[i++] = second[sidx++];
            } else {
                tmp[i++] = second[sidx++];
            }
        }

        while (fidx < first.length) {
            tmp[i++] = first[fidx++];
        }
        while (sidx < second.length) {
            tmp[i++] = second[sidx++];
        }

        for (int j = 0; j < totalLen; j++)
            answer += tmp[j] + " ";

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[] first = new int[N];
        for (int i = 0; i < N; i++) {
            first[i] = kb.nextInt();
        }

        int M = kb.nextInt();
        int[] second = new int[M];
        for (int i = 0; i < M; i++) {
            second[i] = kb.nextInt();
        }

        System.out.println(T.solution(first, second));
    }
}