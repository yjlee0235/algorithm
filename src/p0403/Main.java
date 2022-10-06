package p0403;

import java.util.*;

public class Main {

    private List<Integer> solution(int n, int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer.add(map.size());

        for (int i = k; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            Integer lvalue = map.get(arr[i - k]);
            if (lvalue == 1) {
                map.remove(arr[i - k]);
            } else {
                map.put(arr[i - k], lvalue - 1);
            }
            answer.add(map.size());
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();
        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = kb.nextInt();
        }

        List<Integer> solution = T.solution(N, K, input);
        for (Integer i : solution){
            System.out.print(i + " ");
        }
//        System.out.println(T.solution(N, K, input));
    }
}