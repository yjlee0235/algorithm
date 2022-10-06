package p0805;

import java.util.*;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static boolean[] coinCh = new boolean[501];

    private void dfs(int L, int total, int target, Integer[] coins) {
        if (total > target) {
            return;
        }
        if(L >= answer) {
            return;
        }
        if (total == target) {
            answer = Math.min(answer, L);
        } else {
            for (Integer c : coins) {
                dfs(L + 1, total + c, target, coins);
            }
        }
    }

    private int bfs(int target, Integer[] coins) {
        Deque<Integer> Q = new ArrayDeque<>();

        int L = 0;
        coinCh[0] = true;
        Q.offer(0);
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                int curr = Q.poll();
                for (Integer c : coins) {
                    int next = curr + c;
                    if (next == target) {
                        return L + 1;
                    } else if (next < target && !coinCh[next]) {
                        Q.offer(next);
                        coinCh[next] = true;
                    }
                }
            }
            L++;
        }
        return -1;
    }

    private int solution(int n, int m, Integer[] coins) {
        Arrays.sort(coins, Collections.reverseOrder());
        return bfs(m, coins);
//        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        Integer[] input = new Integer[N];
        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }
        int M = kb.nextInt();

        System.out.println(T.solution(N, M, input));
    }
}