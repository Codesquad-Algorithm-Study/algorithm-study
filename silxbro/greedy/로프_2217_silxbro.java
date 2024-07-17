package silxbro.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 로프_2217_silxbro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] W = new int[N];

        for (int n = 0; n < N; n++) {
            W[n] = scanner.nextInt();
        }

        Arrays.sort(W);

        long maxWeight = Long.MIN_VALUE;
        for (int n = 0; n < N; n++) {
            // 현재 로프가 들어올릴 수 있는 최대치 무게는 이후의 로프만 들어올릴 수 있음
            // 따라서, 현재 로프(최대 무게) * 현재 로프를 포함한 이후의 로프 갯수
            maxWeight = Math.max(maxWeight, W[n] * (N - n));
        }
        System.out.println(maxWeight);
    }
}
