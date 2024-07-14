package horanga.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스_2606_horanga {

    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < L; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        int count = bfs(N);
        System.out.println(count);
    }

    private static int bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1]=true;
        int count =0;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[tmp][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
