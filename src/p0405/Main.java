package p0405;

import java.util.*;

public class Main {

    private int solution(int n, int k, int[] arr) {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int l = j + 1; l < n; l++) {
                    int sum = arr[i] + arr[j] + arr[l];
                    set.add(sum);
                }
            }
        }

        int size = set.size();
        return (size < k) ? -1 : (Integer) set.toArray()[size - k];
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

        System.out.println(T.solution(N, K, input));
    }
}