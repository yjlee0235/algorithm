package p0402;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private String solution1(String first, String second) {
        String answer = "YES";

        Map<Character, Integer> firstCnts = new HashMap<>();
        Map<Character, Integer> secondCnts = new HashMap<>();

        for (char ch : first.toCharArray()) {
            firstCnts.put(ch, firstCnts.getOrDefault(ch, 0) + 1);
        }
        for (char ch : second.toCharArray()) {
            secondCnts.put(ch, secondCnts.getOrDefault(ch, 0) + 1);
        }

        for (char ch : firstCnts.keySet()) {
            if (firstCnts.get(ch) != secondCnts.get(ch)) {
                answer = "NO";
                break;
            }
        }

        return answer;
    }

    private String solution2(String first, String second) {
        String answer = "YES";
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : first.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : second.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return "NO";
            }
            map.put(ch, map.get(ch) - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String first = kb.next();
        String second = kb.next();

        System.out.println(T.solution2(first, second));
    }
}