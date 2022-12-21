package Inflearn.p0401;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private Character solution(String str) {
        Character answer = null;
        Integer max = Integer.MIN_VALUE;

        Map<Character, Integer> voteResult = new HashMap<>();

        for (char ch : str.toCharArray()) {
//            Integer count = voteResult.get(ch);
//            if (count == null) {
//                voteResult.put(ch, 1);
//            } else {
//                voteResult.put(ch, count + 1);
//            }
            voteResult.put(ch, voteResult.getOrDefault(ch, 0) + 1);
        }

        for (char ch : voteResult.keySet()) {
            Integer result = voteResult.get(ch);
            if (max < result) {
                answer = ch;
                max = result;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        String result = kb.next();

        System.out.println(T.solution(result));
    }
}