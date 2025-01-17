package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_2_3더하기_9095_seedspirit {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] numbers = new int[T];
        for(int i=0; i<T; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[11];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;
        
        for(int i=5; i<11; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        for(int number: numbers){
            System.out.println(dp[number]);
        }
    } 
}
