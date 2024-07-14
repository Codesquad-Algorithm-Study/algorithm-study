package silxbro.dfs_bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 바이러스_2606_silxbro {

    private static List<Integer>[] linkInfo;
    private static boolean[] spread;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int computerCount = scanner.nextInt();
        int linkCount = scanner.nextInt();

        linkInfo = new ArrayList[computerCount + 1];
        for (int i = 0; i < linkInfo.length; i++) {
            linkInfo[i] = new ArrayList<>();
        }

        for (int i = 0; i < linkCount; i++) {
            int computerA = scanner.nextInt();
            int computerB = scanner.nextInt();
            linkInfo[computerA].add(computerB);
            linkInfo[computerB].add(computerA);
        }

        spread = new boolean[computerCount + 1];
        dfs(1);

        int answer = 0;
        for (int i = 2; i < spread.length; i++) {
            if (spread[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int now) {
        spread[now] = true;
        for (int next : linkInfo[now]) {
            if (!spread[next]) {
                dfs(next);
            }
        }
    }
}
