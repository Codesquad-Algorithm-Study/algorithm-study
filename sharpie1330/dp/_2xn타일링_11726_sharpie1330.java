package dp;

import java.util.Scanner;

public class _2xn타일링_11726_sharpie1330 {

    private static final int divider = 10_007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;  // 2x1 크기의 직사각형을 채우는 방법은 1가지
        dp[2] = 2;  // 2x2 크기의 직사각형을 채우는 방법은 2가지

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % divider;
        }

        System.out.println(dp[n]);
    }
}
