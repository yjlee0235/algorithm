package p0504;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    private int solution(String str) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (Character ch : str.toCharArray()) {
            if (ch >= '1' && ch <= '9') {
                stack.push(ch - '0');
            }
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                Integer first = Integer.parseInt(stack.pop().toString());
                Integer second = Integer.parseInt(stack.pop().toString());
                switch (ch) {
                    case '+':
                        stack.push(first + second);
                        break;
                    case '-':
                        stack.push(second - first);
                        break;
                    case '*':
                        stack.push(second * first);
                        break;
                    case '/':
                        stack.push(second / first);
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String input = kb.next();

        System.out.println(T.solution(input));
    }
}