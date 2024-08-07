package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579_seedspirit {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N+1];
        for(int i=1; i<N+1; i++){
            scores[i] = Integer.parseInt(br.readLine());
        }
        
        int seq = 0;
        
        // dp 테이블 초기화 및 초기값 세팅
        int[] dp = new int[N+1];
        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];
        dp[3] = scores[1] + scores[2] + scores[3];
        
        // if seq=2 => dp[N] = dp[N-3] + dp[N-1] then seq = 0
        // else dp[N] = Math.max(dp[N-3] + dp[N-2], dp[N-3] + dp[N-1])
        // if dp[N] = dp[N-3] + dp[N-2] => seq ++
        
        // 수정된 로직
        // dp[N] = Math.max(dp[N-2] + dp[N-1], dp[N-3] + dp[N-1])
        for(int i=3; i<N+1; i++){
            if(seq == 2) {
                dp[N] = dp[N-2] + scores[N];
                seq = 0;
            } else {
                dp[N] = Math.max(dp[N-1] + scores[N], dp[N-2] + scores[N]);
                if(dp[N] == dp[N-1] + scores[N]){
                    seq ++;
                }
            }
        }
        System.out.println(dp[N]);
    } 
}
