package dp;

import java.util.Scanner;

public class 계단오르기_2579_sharpie1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        int[] stairs = new int[C + 1];
        for (int i = 1; i < stairs.length; i++) {
            stairs[i] = sc.nextInt();
        }

        // 계단이 한개라면
        if (C == 1) {
            System.out.println(stairs[1]);
            return;
        }

        int[] dp = new int[C + 1];
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        // 세 계단 연속 안됨. 세 번째 계단 밟을 때부터 고려
        for (int i = 3; i < stairs.length; i++) {
            // 두 계단 전을 밟고 지금 계단을 밟을 때랑, 세 계단 전 밟고, 직전 계단 밟고 지금 계단 밟는 경우 비교
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }

        System.out.println(dp[C]);
    }
}
