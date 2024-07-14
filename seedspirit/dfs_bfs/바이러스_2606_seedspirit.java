package seedspirit.dfs_bfs;

import java.io.*;
import java.util.*;

public class 바이러스_2606_seedspirit {

    static ArrayList<Integer>[] topology;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        topology = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            topology[i] = new ArrayList<>();
        }

        for(int j=0; j<M; j++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            topology[s].add(e);
            topology[e].add(s);
        }

        dfs();
        int answer = 0;
        for(boolean b : visited){
            if(b){
                answer ++;
            }
        }
        System.out.println(answer-1);
    }

    private static void dfs(){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        visited[1] = true;
        Integer v;
        while(!stack.isEmpty()){
            v = stack.pop();
            for(int q : topology[v]){
                if(!visited[q]){
                    stack.push(q);
                    visited[q] = true;
                }
            }
        }
    }
}
