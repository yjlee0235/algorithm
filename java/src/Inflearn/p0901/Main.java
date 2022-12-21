package Inflearn.p0901;

import java.util.Arrays;
import java.util.Scanner;

class Player implements Comparable {
    public int height;
    public int weight;

    public Player(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Player p = (Player) o;
        if (this.height == p.height)
            return p.weight - this.weight;
        return p.height - this.height;
    }
}

public class Main {

    private int solution(Player[] players) {
        int answer = players.length;
        int[] ch = new int[players.length];
        Arrays.sort(players);
        for (int i = 0; i < players.length - 1; i++) {
            if (ch[i] == 0) {
                for (int j = i + 1; j < players.length; j++)
                    if (ch[j] == 0 && players[i].height > players[j].height && players[i].weight > players[j].weight) {
                        ch[j] = 1;
                        answer--;
                    }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        Player[] input = new Player[N];
        for (int i = 0; i < N; i++) {
            int height = kb.nextInt();
            int weight = kb.nextInt();
            input[i] = new Player(height, weight);
        }

        System.out.println(T.solution(input));
    }
}