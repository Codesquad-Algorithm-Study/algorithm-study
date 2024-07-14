package seedspirit.dfs_bfs;

import java.io.*;
import java.util.*;

public class DFS와BFS_1260_seedspirit {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static ArrayList<String> answer;
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int j=0; j<M; j++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        // dfs 출력이 자꾸 이상하게 나는데 원인을 모르겠음...
        dfs(V);
        bfs(V);
    }

    private static void dfs(int start){
        answer= new ArrayList<>();
        visited = new boolean[N+1];

        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        int node;

        while(!stack.isEmpty()){
            node = stack.pop();
            answer.add(String.valueOf(node));
            Collections.sort(graph[node], Collections.reverseOrder());
            for(int nodeCandidate : graph[node]){
                if(!visited[nodeCandidate]){
                    visited[nodeCandidate] = true;
                    stack.push(nodeCandidate);
                }
            }
        }

        System.out.println(String.join(" ", answer));
    }

    private static void bfs(int start){
        answer= new ArrayList<>();
        visited = new boolean[N+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        int node;

        while(!queue.isEmpty()){
            node = queue.poll();
            answer.add(String.valueOf(node));
            Collections.sort(graph[node]);
            for(int nodeCandidate : graph[node]){
                if(!visited[nodeCandidate]){
                    visited[nodeCandidate] = true;
                    queue.offer(nodeCandidate);
                }
            }
        }

        System.out.println(String.join(" ", answer));
    }
}