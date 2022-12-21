package Inflearn.p0811;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isValid() {
        return (x >= 0 && x < 7 && y >= 0 && y < 7);
    }
}


public class Main {

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int[][] map = new int[7][7];

    private int bfs(int x, int y) {
        Deque<Point> Q = new ArrayDeque<>();
        map[x][y] = 1;
        Q.offer(new Point(x, y));
        int L = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                Point cur = Q.poll();
                for (int j = 0; j < 4; j++) {
                    Point next = new Point(cur.x + dx[j], cur.y + dy[j]);
                    if (next.x == 6 && next.y == 6) {
                        return L + 1;
                    }
                    if (next.isValid() && map[next.x][next.y] == 0) {
                        map[next.x][next.y] = 1;
                        Q.offer(next);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.bfs(0, 0));
    }
}