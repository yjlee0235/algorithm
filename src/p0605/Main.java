package p0605;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private String solution(int n, int[] arr) {
        Set<Integer> nums = new HashSet<>();

        for(Integer i : arr) {
            if(nums.contains(i)){
                return "D";
            }
            nums.add(i);
        }

        return "U";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }

        System.out.println(T.solution(N, input));
    }
}