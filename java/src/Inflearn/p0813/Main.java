package Inflearn.p0813;

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
}

public class Main {

    static final int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static final int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};

    static int[][] map;
    static int[][] ch;
    static int n;
    static int answer = 0;

    private boolean isValid(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
    private boolean isValid(Point p) {
        return (0 <= p.x && p.x < n && 0 <= p.y && p.y < n);
    }

    private void dfs(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny) && map[nx][ny] == 1 && ch[nx][ny] == 0) {
                ch[nx][ny] = 1;
                dfs(nx, ny);
            }
        }
    }

    private void bfs(int x, int y) {
        Deque<Point> Q = new ArrayDeque<>();
        map[x][y] = 0;
        Q.offer(new Point(x, y));
        while (!Q.isEmpty()) {
            Point cur = Q.poll();
            for (int i = 0; i < 8; i++) {
                Point next = new Point(cur.x + dx[i], cur.y + dy[i]);
                if(isValid(next) && map[next.x][next.y] == 1) {
                    map[next.x][next.y] = 0;
                    Q.offer(next);
                }
            }
        }
    }

    private int solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && ch[i][j] == 0) {
//                    dfs(i, j);
                    bfs(i, j);
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        map = new int[n][n];
        ch = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution());
    }
}