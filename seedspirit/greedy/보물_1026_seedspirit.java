package seedspirit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 보물_1026_seedspirit {
   static ArrayList<Integer> A, B;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        A = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A.add(i, Integer.parseInt(st.nextToken()));
        }
        Collections.sort(A);
        
        B = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            B.add(i, Integer.parseInt(st.nextToken()));
        }
        
        int answer = 0;
        for(int i=0; i<N; i++){
            answer += A.get(i) * Collections.max(B);
            B.remove(Collections.max(B));
        }
        
        System.out.println(answer);
    } 
}
