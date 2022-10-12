package Inflearn.p0502;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    private String solution(String str) {
        String answer = "";
        Deque<Character> stack = new ArrayDeque<>();

        for (Character ch : str.toCharArray()) {
            if (ch.equals('(')) {
                stack.push(ch);
            } else if (ch.equals(')')) {
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    answer += ch;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String input = kb.next();

        System.out.println(T.solution(input));
    }
}