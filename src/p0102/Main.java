package p0102;

import java.util.Scanner;

public class Main {

    private String solution(String input) {
        String answer = "";
        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch))
                answer += Character.toLowerCase(ch);
            else
                answer += Character.toUpperCase(ch);
        }
        return answer;
    }

    private String solution2(String input) {
        char[] chArr = input.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] >= 'a' && chArr[i] <= 'z') {
                chArr[i] -= 'a' - 'A';
            } else {
                chArr[i] += 'a' - 'A';
            }
        }
        return String.valueOf(chArr);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        String input = in.next();

        System.out.println(T.solution(input));
    }
}