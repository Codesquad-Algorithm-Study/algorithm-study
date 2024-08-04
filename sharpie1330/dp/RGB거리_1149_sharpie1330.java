package dp;

import java.util.Scanner;

public class RGB거리_1149_sharpie1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] rgb = new int[N + 1][3];

        for (int i = 1; i < rgb.length; i++) {
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = sc.nextInt();
            }
        }

        // 초기 조건
        int[][] dp = new int[N + 1][3];
        dp[1][0] = rgb[1][0];
        dp[1][1] = rgb[1][1];
        dp[1][2] = rgb[1][2];

        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}
