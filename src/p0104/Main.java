package p0104;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        for (String x : str) {
            String tmp = "";
            int len = x.length();
            for (int i = len - 1; i >= 0; i--) {
                tmp += x.charAt(i);
            }
            answer.add(tmp);
        }

        return answer;
    }

    private ArrayList<String> solution2(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    private ArrayList<String> solution3(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length() - 1;
            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            answer.add(String.valueOf(s));
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = kb.next();
        }
        for (String x : T.solution3(N, str)) {
            System.out.println(x);
        }
    }
}