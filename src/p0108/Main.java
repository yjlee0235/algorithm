package p0108;

import java.util.Scanner;

public class Main {

    private String solution(String str) {
        int lt = 0, rt = str.length() - 1;

        while (lt < rt) {
            char lch = str.charAt(lt);
            char rch = str.charAt(rt);
            if (!Character.isAlphabetic(lch)) {
                lt++;
            } else if (!Character.isAlphabetic(rch)) {
                rt--;
            } else {
                if (Character.toLowerCase(lch) != Character.toLowerCase(rch)) {
                    return "NO";
                }
                lt++;
                rt--;
            }
        }
        return "YES";
    }

    private String solution2(String str) {
        str = str.toLowerCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equals(tmp))
            return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();

        System.out.println(T.solution(input));
    }
}