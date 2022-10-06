package p0208;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private int[] solution(int n, int[] input) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int rank = n + 1;
            for (int j = 0; j < n; j++) {
                if (input[i] >= input[j])
                    rank--;
            }
            answer[i] = rank;
        }

        return answer;
    }

    private int[] solution2(int n, Integer[] input) {
        int[] answer = new int[n];
        Integer[] tmp = input.clone();

        Arrays.sort(tmp, Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (input[i].equals(tmp[j])) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
//        int[] input = new int[N];
        Integer[] input = new Integer[N];
        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }

        int[] answer = T.solution2(N, input);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}