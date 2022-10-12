package Inflearn.p0211;

import java.util.*;

public class Main {

    private int solution(int n, int[][] input) {
        int answer = 1;
        List<Set<Integer>> freq = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            freq.add(new HashSet<>());
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (input[j][i] == input[k][i]) {
                        freq.get(j).add(k + 1);
                        freq.get(k).add(j + 1);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> s = freq.get(i);
            if (max < s.size()) {
                max = s.size();
                answer = i + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[][] input = new int[N][5];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                input[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution(N, input));
    }
}