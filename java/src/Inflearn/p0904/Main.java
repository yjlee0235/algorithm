package Inflearn.p0904;

import java.util.*;

class Lecture implements Comparable<Lecture> {
    public int pay;
    public int dueDays;

    public Lecture(int pay, int dueDays) {
        this.pay = pay;
        this.dueDays = dueDays;
    }

    @Override
    public int compareTo(Lecture lecture) {
        return lecture.dueDays - this.dueDays;
    }
}

public class Main {

    private int solution(Lecture[] lectures, int maxDays) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for (int i = maxDays; i > 0; i--) {
            for (; j < lectures.length; j++) {
                if (lectures[j].dueDays < i) {
                    break;
                }
                pQ.offer(lectures[j].pay);
            }
            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int maxDays = -1;
        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            int pay = kb.nextInt();
            int days = kb.nextInt();
            lectures[i] = new Lecture(pay, days);
            maxDays = Math.max(maxDays, days);
        }
        Arrays.sort(lectures);

        System.out.println(T.solution(lectures, maxDays));
    }
}