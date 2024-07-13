package silxbro.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 촌수계산_2644_silxbro {

    static List<Integer>[] adjList;
    static int[] relativeNumber;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        adjList = new ArrayList[N + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        relativeNumber = new int[N + 1];
        Arrays.fill(relativeNumber, -1);

        int targetA = scanner.nextInt();
        int targetB = scanner.nextInt();
        int relativeCount = scanner.nextInt();

        for (int i = 0; i < relativeCount; i++) {
            int personA = scanner.nextInt();
            int personB = scanner.nextInt();
            adjList[personA].add(personB);
            adjList[personB].add(personA);
        }

        relativeNumber[targetA] = 0;
        dfs(targetA);

        System.out.println(relativeNumber[targetB]);
    }

    private static void dfs(int now) {
        for (int next : adjList[now]) {
            if (relativeNumber[next] == -1) {
                relativeNumber[next] = relativeNumber[now] + 1;
                dfs(next);
            }
        }
    }

}
