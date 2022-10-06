package p0105;

import java.util.Scanner;

public class Main {

    private String solution(String str) {
        int lt = 0, rt = str.length() - 1;
        char[] charArray = str.toCharArray();

        while (lt < rt) {
            boolean isLtAlpha = Character.isAlphabetic(charArray[lt]);
            boolean isRtAlpha = Character.isAlphabetic(charArray[rt]);
            if (!isLtAlpha) {
                lt++;
            } else if (!isRtAlpha) {
                rt--;
            } else {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(charArray);
    }

    private String solution2(String str) {
        int lt = 0, rt = str.length() - 1;
        char[] charArray = str.toCharArray();

        while (lt < rt) {
            boolean isLtAlpha = Character.isAlphabetic(charArray[lt]);
            boolean isRtAlpha = Character.isAlphabetic(charArray[rt]);
            if (isLtAlpha && isRtAlpha) {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }

            while (!Character.isAlphabetic(charArray[lt])) {
                lt++;
            }
            while (!Character.isAlphabetic(charArray[rt])) {
                rt--;
            }
        }

        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String input = kb.next();

        System.out.println(T.solution(input));
    }
}