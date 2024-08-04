package dp;

import java.util.Scanner;

public class 구간합구하기4_11659_sharpie1330 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] numbers = new int[N + 1];
        int[] prefixSum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = scanner.nextInt();
            prefixSum[i] = prefixSum[i - 1] + numbers[i];
        }

        for (int k = 0; k < M; k++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int sum = prefixSum[j] - prefixSum[i - 1];
            System.out.println(sum);
        }
    }
}