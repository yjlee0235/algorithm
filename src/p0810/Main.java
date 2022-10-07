package p0810;

import java.util.Scanner;

public class Main {

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int[][] map = new int[7][7];
    static int answer = 0;

    private boolean isValid(int x, int y) {
        return (x >= 0 && x < 7 && y >= 0 && y < 7);
    }

    private void dfs(int x, int y) {
        if (x == 6 && y == 6) {
            answer++;
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isValid(nx, ny) && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    dfs(nx, ny);
                    map[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = kb.nextInt();
            }
        }
        map[0][0] = 1;

        T.dfs(0, 0);
        System.out.println(answer);
    }
}