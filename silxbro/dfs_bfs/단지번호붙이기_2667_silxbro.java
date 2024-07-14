package silxbro.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 단지번호붙이기_2667_silxbro {

    static boolean[][] houseExist;
    static boolean[][] visited;
    static List<Integer> answer;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int mapSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        mapSize = Integer.parseInt(st.nextToken());

        houseExist = new boolean[mapSize][mapSize];
        visited = new boolean[mapSize][mapSize];
        answer = new ArrayList<>();

        for (int row = 0; row < mapSize; row++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int col = 0; col < mapSize; col++) {
                houseExist[row][col] = line.charAt(col) != '0';
            }
        }

        for (int row = 0; row < mapSize; row++) {
            for (int col = 0; col < mapSize; col++) {
                if (houseExist[row][col] && !visited[row][col]) {
                    answer.add(bfs(row, col));
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }

    private static int bfs(int row, int col) {
        int count = 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextRow = now[0] + dr[d];
                int nextCol = now[1] + dc[d];
                if (nextRow >= 0 && nextRow < mapSize && nextCol >= 0 && nextCol < mapSize) {
                    if (houseExist[nextRow][nextCol] && !visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        queue.add(new int[]{nextRow, nextCol});
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
