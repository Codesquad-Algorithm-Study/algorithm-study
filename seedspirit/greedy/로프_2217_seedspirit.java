package seedspirit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 로프_2217_seedspirit {
   public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        ArrayList<Integer> ropes = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            ropes.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(ropes, Collections.reverseOrder());
        int maxWeight = 0;
        int candidate = 0;
        
        for(int i=0; i<N; i++){
            candidate = ropes.get(i) * (i+1);
            if(maxWeight < candidate){
                maxWeight = candidate;
            }
        }
        
        System.out.println(maxWeight);
    } 
}
