package p0708;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Info {
    public int current;
    public int moveCnt;

    public Info(int current, int moveCnt) {
        this.current = current;
        this.moveCnt = moveCnt;
    }
}

public class Main {
    static int[] move = {1, -1, 5};
    static boolean[] isVisited = new boolean[10001];


    private int solution(int start, int dest) {
        Deque<Info> Q = new ArrayDeque<>();

        Q.offer(new Info(start, 0));
        isVisited[start] = true;
        while (!Q.isEmpty()) {
            Info cur = Q.poll();
            for (int i = 0; i < move.length; i++) {
                int next = cur.current + move[i];
                if (next == dest) {
                    return cur.moveCnt + 1;
                }
                if (next >= 0 && next < 10000 && !isVisited[next]) {
                    Q.offer(new Info(next, cur.moveCnt + 1));
                    isVisited[next] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int start = kb.nextInt();
        int dest = kb.nextInt();

        System.out.println(T.solution(start, dest));
    }
}