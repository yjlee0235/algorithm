package Inflearn.p0507;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    private String solution1(String str1, String str2) {
        String answer = "YES";
        Deque<Character> classes = new ArrayDeque<>();

        for (Character ch : str2.toCharArray()) {
            classes.offer(ch);
        }

        int i = 0;
        Character ch;
        while (i < str1.length() && !classes.isEmpty()) {
            ch = classes.poll();
            if (ch.equals(str1.charAt(i))) {
                i++;
            }
        }
        if (i != str1.length())
            return "NO";
        return answer;
    }

    private String solution2(String str1, String str2) {
        Deque<Character> Q = new ArrayDeque<>();
        for (Character ch : str1.toCharArray()) {
            Q.offer(ch);
        }

        for (Character ch : str2.toCharArray()) {
            if (ch.equals(Q.peekFirst())) {
                Q.poll();
                if (Q.isEmpty())
                    return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String input1 = kb.next();
        String input2 = kb.next();

        System.out.println(T.solution2(input1, input2));
    }
}