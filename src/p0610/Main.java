package p0610;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private boolean canPlace(int[] arr, int horseCnt, int dist) {
        int realHorseCnt = 1;

        int sum = 0;
        for (int i = 0; i < arr.length && realHorseCnt <= horseCnt - 1; i++) {
            sum += arr[i];
            if (sum >= dist) {
                realHorseCnt++;
                sum = 0;
            }
        }

        return (realHorseCnt == horseCnt);
    }

    private int solution(int n, int c, int[] dists) {
        int answer = 0;
        int rt = dists[n - 1] - dists[0], lt = rt;

        int[] tmp = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            tmp[i] = dists[i + 1] - dists[i];
            if (lt > tmp[i]) {
                lt = tmp[i];
            }
        }

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (canPlace(tmp, c, mid)) {
                lt = mid + 1;
                answer = mid;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int C = kb.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }
        Arrays.sort(input);

        System.out.println(T.solution(N, C, input));
    }
}