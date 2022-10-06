package p0607;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Point implements Comparable<Point> {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if (this.x == point.x)
                return this.y - point.y;
            else
                return this.x - point.x;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Point p = new Point(kb.nextInt(), kb.nextInt());
            points.add(p);
        }
        points.sort(Point::compareTo);

        for (Point p : points) {
            System.out.println(p.x + " " + p.y);
        }
    }
}