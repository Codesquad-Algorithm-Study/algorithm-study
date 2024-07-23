package seedspirit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 동전0_11047_seedspirit {
     
    static ArrayList<Integer> assets;
    static int N, K;
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        assets = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            assets.add(0, Integer.parseInt(st.nextToken()));
        }
        
        for(int asset: assets){
            int tmp = K / asset;
            if(tmp == 0){
                continue;
            }
            answer += tmp;
            K -= asset * tmp;
        }
        
        System.out.println(answer);
    } 
}
