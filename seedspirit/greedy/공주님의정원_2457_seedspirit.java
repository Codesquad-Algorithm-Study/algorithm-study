package seedspirit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 공주님의정원_2457_seedspirit {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] flowers = new int[N][4];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                flowers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 개화 날짜가 빠른 순서대로 정렬. 같은 개화라면 더 오래 피어있는 꽃 순서로 정렬
        Arrays.sort(flowers, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    if(o1[1] == o2[1]){
                        if(o1[2] == o2[2]){
                            return o2[3] - o1[3];
                        }
                        return o2[2] - o1[2];
                    }
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        
        int answer = 0;
        int prev_start_month = 1;
        int prev_start_day = 1;
        int prev_end_month = 1;
        int prev_end_day = 1;
        
        
        for(int i=0; i<N; i++){
            if(flowers[i][0] < 3 && flowers[i][2] < 3){
                continue;
            }
            
            if(flowers[i][0] > prev_end_month || flowers[i][1] >= prev_end_day){
                continue;
            }
            
            if(flowers[i][2] < prev_end_month || flowers[i][3] <= prev_end_day){
                continue;
            }
            
            prev_start_month = flowers[i][0];
            prev_start_day = flowers[i][1];
            prev_end_month = flowers[i][2];
            prev_end_day = flowers[i][3];
        }
        
        if(prev_end_month < 11 || (prev_end_month == 11 && prev_end_day <= 30)){
            answer = 0;
        }
        System.out.println(answer);
    } 
}
