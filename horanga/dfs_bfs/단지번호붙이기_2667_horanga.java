package horanga.dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 단지번호붙이기_2667_horanga {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dy= {0, 1, 0, -1};
    static int[] dx= {1, 0, -1, 0};
    static int N;
    static int count =1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();

        arr = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> result= new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for(int j=0; j<N; j++){
                arr[i][j] = line.charAt(j)-'0';
            }
        }


        for(int x=0; x<N; x++){
            for(int y=0; y<N; y++){
                if(arr[x][y]==1&& !visited[x][y]) {
                    dfs(x, y);
                    result.add(count);
                    count=1;
                }
            }
        }


        System.out.println(result.size());
        Collections.sort(result);
        result.forEach(System.out::println);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;


        for(int i =0; i<4; i++){
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]&& arr[nx][ny]==1){
                dfs(nx, ny);
                count++;
            }
        }

    }

}
