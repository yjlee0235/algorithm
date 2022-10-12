package Inflearn.p0112;

import java.util.Scanner;

public class Main {

    private String solution(int n, String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i += 7) {
            String tmp = "";
            for (int j = 0; j < 7; j++) {
                tmp += (str.charAt(i + j) == '#') ? '1' : '0';
            }
            answer += (char) Integer.parseInt(tmp, 2);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        String input = kb.next();

        System.out.println(T.solution(N, input));
    }
}