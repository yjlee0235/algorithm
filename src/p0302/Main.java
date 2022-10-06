package p0302;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private String solution(int[] first, int[] second) {
        String answer = "";
        int maxSize = Math.max(first.length, second.length);
        int[] dupArr = new int[maxSize];
        int fidx = 0, sidx = 0, j = 0;
        Arrays.sort(first);
        Arrays.sort(second);

        while (fidx < first.length && sidx < second.length) {
            if (first[fidx] == second[sidx]) {
                dupArr[j++] = first[fidx++];
                sidx++;
            } else if (first[fidx] < second[sidx]) {
                fidx++;
            } else {
                sidx++;
            }
        }

        for (int i = 0; i < maxSize && dupArr[i] > 0; i++) {
            answer += dupArr[i] + " ";
        }

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