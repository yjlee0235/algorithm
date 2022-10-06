package p0110;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private String solution(String str, char ch) {
        List<Integer> chPos = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                chPos.add(i);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (Integer idx : chPos) {
                int dist = (i - idx) > 0 ? (i - idx) : (idx - i);
                if (min > dist) {
                    min = dist;
                }
            }
            result.add(min);
        }

        return integerListToString(result);
    }

    private String solution2(String str, char ch) {
        int[] result = new int[str.length()];
        int p = 1000;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                p = 0;
            } else {
                p++;
            }
            result[i] = p;
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ch)
                p = 0;
            else {
                p++;
                result[i] = Math.min(p, result[i]);
            }
        }

        return intArrToString(result);
    }

    private String integerListToString(List<Integer> list) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            result += (i == list.size() - 1) ? list.get(i) : list.get(i) + " ";
        }
        return result;
    }

    private String intArrToString(int[] arr){
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += (i == arr.length - 1) ? arr[i] : arr[i] + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String input = kb.next();
        String ch = kb.next();

        System.out.println(T.solution2(input, ch.charAt(0)));
    }
}