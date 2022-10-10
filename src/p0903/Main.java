package p0903;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Friend {
    public int start;
    public int end;

    public Friend(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Time implements Comparable<Time> {
    public int hour;
    public char state;

    public Time(int hour, char state) {
        this.hour = hour;
        this.state = state;
    }

    @Override
    public int compareTo(Time t) {
        if (this.hour == t.hour)
            return this.state - t.state;
        return this.hour - t.hour;
    }
}

public class Main {
    private int solution(Friend[] friends) {
        int answer = Integer.MIN_VALUE;
        int[] time = new int[73];

        for (Friend f : friends) {
            for (int i = f.start; i < f.end; i++) {
                time[i]++;
            }
        }

        for (int i = 0; i < time.length; i++) {
            answer = Math.max(answer, time[i]);
        }
        return answer;
    }

    private int solution2(List<Time> times) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(times);
        int cnt = 0;
        for (Time t : times) {
            if (t.state == 's') {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

//    public static void main(String[] args) {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int N = kb.nextInt();
//        Friend[] input = new Friend[N];
//        for (int i = 0; i < N; i++) {
//            int start = kb.nextInt();
//            int end = kb.nextInt();
//            input[i] = new Friend(start, end);
//        }
//
//        System.out.println(T.solution(input));
//    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        List<Time> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            arr.add(new Time(start, 's'));
            arr.add(new Time(end, 'e'));
        }
        System.out.println(T.solution2(arr));
    }
}