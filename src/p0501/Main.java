package p0501;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    private String solution(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (Character ch : str.toCharArray()) {
            if (ch.equals('(')) {
                stack.push(ch);
            } else if (ch.equals(')')) {
                if (stack.isEmpty())
                    return "NO";
                else
                    stack.pop();
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String input = kb.next();

        System.out.println(T.solution(input));
    }
}