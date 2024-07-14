package seedspirit.dfs_bfs;

import java.io.*;
import java.util.*;

public class 미로탐색_2178_seedspirit {
    static int N, M;
    static int[] dx = {1, -1, 0 , 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int y, x;
        int ny, nx;
        int[] tmp;

        while(!queue.isEmpty()){
            tmp = queue.poll();
            y = tmp[0];
            x = tmp[1];

            for(int i=0; i<4; i++){
                ny = y + dy[i];
                nx = x + dx[i];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N){
                    continue;
                }
                if(!visited[ny][nx]){
                    visited[ny][nx] = true;
                    map[ny][nx] += map[y][x];
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }
}
