package Inflearn.p0506;

import java.util.*;

public class Main {

    private int solution1(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int tmp = 0, size;
        while ((size = list.size()) > 1) {
            tmp += k - 1;
            tmp %= size;
            list.remove(tmp);
        }

        return list.get(0);
    }

    private int solution2(int n, int k) {
        int answer = -1;
        Deque<Integer> Q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            Q.offer(i);
        while (!Q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                Q.offer(Q.poll());
            }
            Q.poll();
            if (Q.size() == 1)
                answer = Q.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();

        System.out.println(T.solution2(N, K));
    }
}