package p0902;

import java.util.Arrays;
import java.util.Scanner;

class Conference implements Comparable {
    public int start;
    public int end;

    public Conference(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Object o) {
        Conference c = (Conference) o;
        if (this.end == c.end)
            return this.start - c.start;
        return this.end - c.end;
    }
}

public class Main {

    private int solution(Conference[] conf) {
        int answer = 1;
        Conference before = conf[0];
        for (int i = 1; i < conf.length; i++) {
            if (before.end <= conf[i].start) {
                before = conf[i];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        Conference[] input = new Conference[N];
        for (int i = 0; i < N; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            input[i] = new Conference(start, end);
        }
        Arrays.sort(input);

        System.out.println(T.solution(input));
    }
}