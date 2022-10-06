package p0107;

import java.util.Scanner;

public class Main {

    private String solution(String str) {
        int lt = 0, rt = str.length() - 1;

        while (lt < rt) {
            if (Character.toLowerCase(str.charAt(lt)) == Character.toLowerCase(str.charAt(rt))) {
                lt++;
                rt--;
            } else {
                return "NO";
            }
        }
        return "YES";
    }

    private String solution2(String str) {
        str = str.toLowerCase();

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return "NO";
            }
        }
        return "YES";
    }

    private String solution3(String str) {
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(tmp))
            return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String input = kb.next();

        System.out.println(T.solution3(input));
    }
}