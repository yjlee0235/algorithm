package p0907;

import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    public int from;
    public int to;
    public int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}

public class Main {

    static PriorityQueue<Edge> pQ = new PriorityQueue<>();
    static int[] vertexConnect;

    private int find(int x) {
        if (vertexConnect[x] == x)
            return x;
        return vertexConnect[x] = find(vertexConnect[x]);
    }

    private int solution() {
        int answer = 0;

        while (!pQ.isEmpty()) {
            Edge selected = pQ.poll();
            int x = find(selected.from);
            int y = find(selected.to);
            if(x != y) {
                vertexConnect[x] = y;
                answer += selected.weight;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int V = kb.nextInt();
        int E = kb.nextInt();
        vertexConnect = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            vertexConnect[i] = i;
        }
        for (int i = 0; i < E; i++) {
            int sv = kb.nextInt();
            int ev = kb.nextInt();
            int w = kb.nextInt();
            pQ.offer(new Edge(sv, ev, w));
        }

        System.out.println(T.solution());
    }
}