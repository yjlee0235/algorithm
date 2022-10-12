package Inflearn.p0109;

import java.util.Scanner;

public class Main {

    private Integer solution(String str) {
        String answer = "";

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                answer += ch;
            }
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String input = kb.next();

        System.out.println(T.solution(input));
    }
}