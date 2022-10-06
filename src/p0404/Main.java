package p0404;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private int solution(String str, String sub) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> subMap = new HashMap<>();

        for (int i = 0; i < sub.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            subMap.put(sub.charAt(i), subMap.getOrDefault(sub.charAt(i), 0) + 1);
        }
        if (map.equals(subMap)) {
            answer++;
        }

        for (int rt = sub.length(); rt < str.length(); rt++) {
            map.put(str.charAt(rt), map.getOrDefault(str.charAt(rt), 0) + 1);
            Integer lvalue = map.get(str.charAt(rt - sub.length()));
            if (lvalue == 1) {
                map.remove(str.charAt(rt - sub.length()));
            } else
                map.put(str.charAt(rt - sub.length()), lvalue - 1);
            if (map.equals(subMap)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String input = kb.next();
        String sub = kb.next();

        System.out.println(T.solution(input, sub));
    }
}