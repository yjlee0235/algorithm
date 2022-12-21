package Inflearn.p0103;

import java.util.Scanner;

public class Main {

    private String solution(String input) {
        int startIdx = 0;
        int maxStartIdx = 0;
        int maxLength = -1;

        boolean isFirst = true;

        char[] chArr = input.toCharArray();

        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] != ' ' && isFirst) {
                startIdx = i;
                isFirst = false;
            }
            if (chArr[i] == ' ' || i + 1 == chArr.length) {
                if (i + 1 == chArr.length)
                    i++;
                if (i - startIdx > maxLength) {
                    maxLength = i - startIdx;
                    maxStartIdx = startIdx;
                }
                isFirst = true;
            }
        }

        return input.substring(maxStartIdx, maxStartIdx + maxLength);
    }

    private String solution2(String input) {
        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] s = input.split(" ");
        for (String x : s) {
            int len = x.length();
            if (len > m) {
                m = len;
                answer = x;
            }
        }
        return answer;
    }

    private String solution3(String input) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while ((pos = input.indexOf(' ')) != -1) {
            String tmp = input.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            input = input.substring(pos + 1);
        }
        if (input.length() > m) {
            answer = input;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String in = kb.nextLine();
        System.out.println(T.solution3(in));
    }
}
