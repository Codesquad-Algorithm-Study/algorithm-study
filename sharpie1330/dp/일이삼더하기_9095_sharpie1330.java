package dp;

import java.util.Scanner;

public class 일이삼더하기_9095_sharpie1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dp = new int[11 + 1];

        dp[0] = 1;  // 아무것도 선택 x
        dp[1] = 1;  // 1 하나만
        dp[2] = 2;  // 1+1, 2하나
        dp[3] = 4;  // 1+1+1, 1+2, 2+1, 3
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
