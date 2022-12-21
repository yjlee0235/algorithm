package Inflearn.p0714;

import java.util.*;

public class Main {

    static class Solution {
        static int[] isVisited;
        static ArrayList<ArrayList<Integer>> graph;

        public static String solve1(int start) {
            int[] answer = new int[graph.size()];
            Deque<Integer> Q = new ArrayDeque<>();
            int L = 0;

            isVisited[start] = 1;
            Q.offer(start);
            while (!Q.isEmpty()) {
                int size = Q.size();
                for (int i = 0; i < size; i++) {
                    int curr = Q.poll();
                    for (int nv : graph.get(curr)) {
                        if (isVisited[nv] == 0) {
                            Q.offer(nv);
                            isVisited[nv] = 1;
                            answer[nv] = L + 1;
                        }
                    }
                }
                L++;
            }

            String answerStr = "";
            for (int i = 1; i < answer.length; i++) {
                if (i == start)
                    continue;
                answerStr += i + ":" + answer[i] + "\n";
            }

            return answerStr;
        }

        public static String solve2(int start) {
            Deque<Integer> Q = new ArrayDeque<>();
            int[] answer = new int[graph.size()];

            isVisited[start] = 1;
            answer[start] = 0;
            Q.offer(start);
            while (!Q.isEmpty()) {
                int cur = Q.poll();
                for (Integer next : graph.get(cur)) {
                    if (isVisited[next] == 0) {
                        Q.offer(next);
                        answer[next] = answer[cur] + 1;
                        isVisited[next] = 1;
                    }
                }
            }

            String answerStr = "";
            for (int i = 1; i < answer.length; i++) {
                if (i == start) {
                    continue;
                }
                answerStr += i + ":" + answer[i] + "\n";
            }
            return answerStr;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        Solution.graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            Solution.graph.add(new ArrayList<>());
        }
        Solution.isVisited = new int[m];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            Solution.graph.get(a).add(b);
        }

        System.out.println(Solution.solve2(1));
    }
}