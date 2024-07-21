package seedspirit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ATM_11399_seedspirit {
        public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> queue = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            queue.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(queue, Collections.reverseOrder());
        
        int answer=0;
        for(int i=0; i<N; i++){
            answer += (i+1) * queue.get(i);
        }    
        
        System.out.println(answer);
    }
}
