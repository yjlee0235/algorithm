package Inflearn.p0814;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int calcDist(int x, int y) {
        return Math.abs(this.x - x) + Math.abs(this.y - y);
    }

    public int calcDist(Point p) {
        return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
    }
}

public class Main {

    static int n;
    static int[][] map;
    static int[] selected;

    static List<Point> housePos = new ArrayList<>();
    static List<Point> pizzaPos = new ArrayList<>();

    static int answer = Integer.MAX_VALUE;

    private int calcMinPizzaDist() {
        int total = 0;
        for (Point hp : housePos) {
            int minDist = Integer.MAX_VALUE;
            for (int si : selected) {
                minDist = Math.min(minDist, hp.calcDist(pizzaPos.get(si)));
            }
            total += minDist;
        }
        return total;
    }

    private void dfs(int L, int s) {
        if (L == selected.length) {
            answer = Math.min(answer, calcMinPizzaDist());
        } else {
            for (int i = s; i < pizzaPos.size(); i++) {
                selected[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    private int solution(int m) {
        dfs(0, 0);
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int M = kb.nextInt();
        map = new int[n][n];
        selected = new int[M];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = kb.nextInt();
                switch (map[i][j]) {
                    case 1:
                        housePos.add(new Point(i, j));
                        break;
                    case 2:
                        pizzaPos.add(new Point(i, j));
                        break;
                    default:
                        break;
                }
            }
        }

        System.out.println(T.solution(M));
    }
}