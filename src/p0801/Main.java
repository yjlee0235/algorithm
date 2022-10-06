package p0801;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] input;
    static int target;
    static boolean flag = false;

    private void DFS(int L, int sum) {
        if(flag || sum > target){
            return;
        }
        if(L == input.length) {
            if(sum == target) {
                flag = true;
                return;
            }
        } else {
            DFS(L+1, sum + input[L]);
            DFS(L+1, sum);
        }
    }

    private String solution(int n, int[] arr) {
        int total = Arrays.stream(arr).sum();
        if (total % 2 == 1) {
            return "NO";
        }

        target = total / 2;
        DFS(0, 0);

        return flag ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }

        System.out.println(T.solution(N, input));
    }
}