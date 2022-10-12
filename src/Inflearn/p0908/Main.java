package Inflearn.p0908;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    public int vertex;
    public int weight;

    public Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}

public class Main {
    static ArrayList<ArrayList<Edge>> graph;
    static boolean[] vertexConnect;

    private int solution() {
        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));
        while (!pQ.isEmpty()) {
            Edge next = pQ.poll();
            if (!vertexConnect[next.vertex]) {
                answer += next.weight;
                vertexConnect[next.vertex] = true;
                for (Edge e : graph.get(next.vertex)) {
                    if (!vertexConnect[e.vertex]) {
                        pQ.offer(e);
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int V = kb.nextInt();
        int E = kb.nextInt();
        graph = new ArrayList<>();
        vertexConnect = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int sv = kb.nextInt();
            int ev = kb.nextInt();
            int w = kb.nextInt();
            graph.get(sv).add(new Edge(ev, w));
            graph.get(ev).add(new Edge(sv, w));
        }

        System.out.println(T.solution());
    }
}