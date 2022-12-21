package Inflearn.p0812;

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

    public boolean isValid(int m, int n) {
        return (0 <= x && x < m && 0 <= y && y < n);
    }
}

public class Main {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};

    static int[][] box;

    private boolean isItAllRed() {
        for (int[] row : box) {
            for (int col : row) {
                if (col == 0)
                    return false;
            }
        }
        return true;
    }

    private int bfs(int m, int n) {
        Deque<Point> Q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j] == 1) {
                    Q.offer(new Point(i, j));
                }
            }
        }

        int L = 0;
        while (!Q.isEmpty()) {
            if (isItAllRed()) {
                return L;
            }
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                Point cur = Q.poll();
                for (int j = 0; j < 4; j++) {
                    Point next = new Point(cur.x + dx[j], cur.y + dy[j]);
                    if (next.isValid(m, n) && box[next.x][next.y] == 0) {
                        box[next.x][next.y] = 1;
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
        int N = kb.nextInt();
        int M = kb.nextInt();
        box = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                box[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.bfs(M, N));
    }

//    public static void main(String[] args) throws IOException {
//        Main T = new Main();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        StringTokenizer st = new StringTokenizer(str);
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                box[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        System.out.println(T.bfs(M, N));
//    }
}