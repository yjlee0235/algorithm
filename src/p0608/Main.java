package p0608;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

//    private int find(int sidx, int fidx, int[] arr, int m) {
//        int midx = (sidx + fidx) / 2;
//
//        if (arr[midx] == m)
//            return midx + 1;
//        else if (arr[midx] < m)
//            return find(sidx, midx, arr, m);
//        else
//            return find(midx, sidx, arr, m);
//    }

    private int solution(int m, int[] arr) {
        Arrays.sort(arr);
        int sidx = 0, fidx = arr.length - 1;

        while (sidx <= fidx) {
            int midx = (sidx + fidx) / 2;

            if (arr[midx] == m)
                return midx + 1;
            else if (arr[midx] < m)
                sidx = midx + 1;
            else
                fidx = midx - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int M = kb.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }

        System.out.println(T.solution(M, input));
    }
}