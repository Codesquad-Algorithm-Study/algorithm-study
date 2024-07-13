package silxbro.dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DFS와BFS_1260_silxbro {
    private static List<Integer>[] adjList;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int V = scanner.nextInt();

        // 인접리스트 초기화
        adjList = new ArrayList[N + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int nodeA = scanner.nextInt();
            int nodeB = scanner.nextInt();
            adjList[nodeA].add(nodeB);
            adjList[nodeB].add(nodeA);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        // dfs 실행
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // bfs 실행
        visited = new boolean[N + 1];
        bfs(V);
    }

    private static void dfs(int now) {
        visited[now] = true;
        System.out.print(now + " ");
        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int next : adjList[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
