package Inflearn.p1004;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Block implements Comparable<Block> {
    public int bottom;
    public int height;
    public int weight;

    public Block(int bottom, int height, int weight) {
        this.bottom = bottom;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Block block) {
        if (this.bottom == block.bottom)
            return block.weight - this.weight;
        return block.bottom - this.bottom;
    }
}

public class Main {

    static ArrayList<Block> blocks = new ArrayList<>();

    private int solution() {
        int answer = 0;
        int[] dp = new int[blocks.size()];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = blocks.get(i).height;
        }

        for (int i = 1; i < dp.length; i++) {
            Block block = blocks.get(i);
            for (int j = i - 1; j >= 0; j--) {
                Block tmp = blocks.get(j);
                if (block.bottom < tmp.bottom && block.weight < tmp.weight && dp[i] < dp[j] + block.height) {
                    dp[i] = dp[j] + block.height;
                    answer = Math.max(answer, dp[i]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        for (int i = 0; i < N; i++) {
            int bottom = kb.nextInt();
            int height = kb.nextInt();
            int weight = kb.nextInt();
            blocks.add(new Block(bottom, height, weight));
        }
        Collections.sort(blocks);

        System.out.println(T.solution());
    }
}