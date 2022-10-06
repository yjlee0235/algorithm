package p0111;

import java.util.Scanner;

public class Main {

    private String solution(String str) {
        String answer = "";
        char c = '\0';
        int cCount = 1;

        for (int i = 0; i < str.length(); i++) {
            if (c == '\0') {
                c = str.charAt(i);
            } else if (str.charAt(i) != c) {
                answer += (cCount > 1) ? c + String.valueOf(cCount) : c;
                c = str.charAt(i);
                cCount = 1;
                if (i == str.length() - 1) {
                    answer += (cCount > 1) ? c + String.valueOf(cCount) : c;
                }
            } else {
                cCount++;
            }

            if (i == str.length() - 1 && cCount > 1) {
                answer += c + String.valueOf(cCount);
            }
        }

        return answer;
    }

    private String solution2(String str) {
        String answer = "";
        int count = 1;

        str += " ";
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                answer += (count > 1) ? str.charAt(i) + String.valueOf(count) : str.charAt(i);
                count = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String input = kb.next();

        System.out.println(T.solution2(input));
    }
}