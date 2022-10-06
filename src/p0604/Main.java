package p0604;

import java.util.Scanner;

public class Main {

    private String solution(int s, int n, int[] arr) {
        String answer = "";
        int[] cache = new int[s];
        int j;

        cache[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            j = 0;
            while (cache[j] != 0 && j < s - 1 && cache[j] != arr[i]) j++;

            for (int k = j; k > 0; k--) {
                cache[k] = cache[k - 1];
            }
            cache[0] = arr[i];
        }

        for (int i = 0; i < s && cache[i] != 0; i++) {
            answer += cache[i] + " ";
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int S = kb.nextInt();
        int N = kb.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }

        System.out.println(T.solution(S, N, input));
    }
}