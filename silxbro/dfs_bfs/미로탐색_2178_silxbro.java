package silxbro.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 미로탐색_2178_silxbro {

    private static int[][] maze;
    private static boolean[][] visited;
    private static int row, col;
    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        maze = new int[row][col];
        visited = new boolean[row][col];

        for (int r = 0; r < row; r++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int c = 0; c < col; c++) {
                maze[r][c] = Integer.parseInt(line.substring(c, c + 1));
            }
        }

        bfs();

        System.out.println(maze[row-1][col-1]);

    }

    private static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextRow = now[0] + dr[d];
                int nextCol = now[1] + dc[d];
                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col) {
                    if (!visited[nextRow][nextCol] && maze[nextRow][nextCol] != 0) {
                        visited[nextRow][nextCol] = true;
                        maze[nextRow][nextCol] = maze[now[0]][now[1]] + 1;
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
    }
}
