package p0202;

import java.util.Scanner;

public class Main {

    private int solution(int n, int[] arr) {
        int answer = 0;
        int beforeMax = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(beforeMax < arr[i]) {
                beforeMax = arr[i];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(N, arr));
    }
}