package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 공주님의정원_2457_sharpie1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 3 1 11 30 - 매일 꽃이 한 가지 이상 피어있어야
        // 가능한 적게
        int[][] flowers = new int[N][2];
        for (int i = 0; i < N; i++) {
            int startMonth = sc.nextInt();
            int startDay = sc.nextInt();
            int endMonth = sc.nextInt();
            int endDay = sc.nextInt();
            flowers[i][0] = startMonth * 100 + startDay;    // ex - 301
            flowers[i][1] = endMonth * 100 + endDay;    // ex - 1130
        }

        flowers = Arrays.stream(flowers)
                .sorted(Comparator.comparingInt((int[] flower) -> flower[0])
                        .thenComparingInt(flower -> flower[1]))
                .toArray(int[][]::new);

        int start = 301;
        int end = 1130;

        int maxEnd = 0;
        int count = 0;

        int i = 0;

        while (start <= end) {  // 시작일은 새로운 maxEnd로 갱신되므로
            boolean found = false;

            while (i < N && flowers[i][0] <= start) {
                if (flowers[i][1] > maxEnd) {
                    maxEnd = flowers[i][1];
                    found = true;
                }
                i++;
            }

            if (!found) {
                System.out.println(0);
                return;
            }

            count++;
            start = maxEnd;
        }

        System.out.println(count);
    }
}
