package p0505;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    private int solution(String str) {
        int answer = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                stack.pop();
                answer += (str.charAt(i - 1) == '(') ? stack.size() : 1;
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