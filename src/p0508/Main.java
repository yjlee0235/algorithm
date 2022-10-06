package p0508;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    private int solution1(int n, int m, int[] arr) {
        int answer = 0;
        Deque<Integer> Q = new ArrayDeque<>();
        int pos = m;

        for (Integer i : arr) {
            Q.offer(i);
        }

        outer:
        while (!Q.isEmpty()) {
            Integer first = Q.poll();
            pos--;
            for (Integer i : Q) {
                if (first < i) {
                    pos = (pos < 0) ? Q.size() : pos;
                    Q.offer(first);
                    continue outer;
                }
            }
            answer++;
            if (pos == -1)
                return answer;
        }
        return answer;
    }

    class Person {
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    private int solution2(int n, int m, int[] arr) {
        int answer = 0;
        Deque<Person> Q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Q.offer(new Person(i, arr[i]));
        }
        while (!Q.isEmpty()) {
            Person tmp = Q.poll();
            for (Person p : Q) {
                if (p.priority > tmp.priority) {
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == m)
                    return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int M = kb.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }

        System.out.println(T.solution2(N, M, input));
    }
}