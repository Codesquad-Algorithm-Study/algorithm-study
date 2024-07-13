package horanga.dfs_bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class DFS와BFS_1260_horanga {

    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) {

        //정점의 개수(n), 간선의 개수 (m), 탐색을 시작할 번호 (v)
        //그 다음 m개의 줄에는 간선을 연결하는 두 정점의 번호가 주어짐


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt();


        arr = new int[n+1][n+1];
        for(int i =0; i<m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[n+1];
        dfs(v);
        System.out.println();

        visited = new boolean[n+1];
        bfs(v);


    }


    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v+ " ");

        if(v== arr.length){
            return;
        }

        for(int j =1; j<arr.length; j++){
            if(arr[v][j]==1 && visited[j]==false){
                dfs(j);
            }
        }

    }
    private static void bfs(int v) {

        LinkedList<Integer> que = new LinkedList<>();

        que.add(v);
        visited[v]= true;
        System.out.print(v+ " ");

        while(!que.isEmpty()){
            int temp = que.poll();
            for(int i =1; i<arr.length; i++){
                if(arr[temp][i]==1 && visited[i]==false){
                    que.add(i);
                    visited[i] = true;
                    System.out.print(i+ " ");
                }
            }
        }



    }

}
