package horanga.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_2178_horanga {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    static int cnt =1;

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0,1, 0, -1};


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];

        String str;

        for(int i=0; i<n; i++) {
            str = scanner.next();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(map[n-1][m-1]); // 끝 지점의 값 출력

    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        int[] tmp = new int[2];
        visited[0][0]=true;

        int y, x;
        int ny, nx;

        while(!queue.isEmpty()){
            tmp = queue.poll();
            y = tmp[0];
            x = tmp[1];

            for(int i =0; i<4; i++){
                ny = y+ dy[i];
                nx = x+ dx[i];

                if(ny<0 || nx<0 || ny>=n || nx>=m)continue;
                if(!visited[ny][nx] &&map[ny][nx]==1){
                    visited[ny][nx] =true;
                    map[ny][nx] += map[y][x];
                    queue.add(new int[] {ny, nx});
                }
            }
        }


    }
}
