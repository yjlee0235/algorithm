package Inflearn.p0609;

import java.util.Scanner;

public class Main {

    private int calcCdCount(int[] arr, int capacity) {
        int sum = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > capacity) {
                sum = 0;
                count++;
            }
            sum += arr[i];
        }
        if (sum <= capacity)
            count++;

        return count;
    }

    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = -1, rt = 0, mid;

        for (int i : arr) {
            lt = Math.max(lt, i);
            rt += i;
        }

        while (lt <= rt) {
            mid = (lt + rt) / 2;
            int result = calcCdCount(arr, mid);
            if (result <= m) {
                rt = mid - 1;
                answer = mid;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
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

        System.out.println(T.solution(N, M, input));
    }
}