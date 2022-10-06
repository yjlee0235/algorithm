package p0305;

import java.util.Scanner;

public class Main {

    private int solution(int n) {
        int answer = 0;
        int tmp = 0, lt = 1;

        for (int rt = 1; rt < n / 2 + 1; rt++) {
            tmp += rt;
            if (tmp == n)
                answer++;
            while (tmp >= n) {
                tmp -= lt++;
                if (tmp == n)
                    answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        System.out.println(T.solution(N));
    }
}