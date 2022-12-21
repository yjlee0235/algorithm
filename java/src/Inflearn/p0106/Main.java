package Inflearn.p0106;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private String solution(String str) {
        String answer = "";

        for (char ch : str.toCharArray()) {
            if (answer.indexOf(ch) == -1) {
                answer += ch;
            }
        }

        return answer;
    }

    private String solution2(String str) {
        Set<Character> set = new LinkedHashSet<>();
        String answer = "";

        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        for (char ch : set) {
            answer += ch;
        }

        return answer;
    }

    private String solution3(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (str.indexOf(ch) == i)
                answer += ch;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String input = kb.next();

        System.out.println(T.solution3(input));
    }
}