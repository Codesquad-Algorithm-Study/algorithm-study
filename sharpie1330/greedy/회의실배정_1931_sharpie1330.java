package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 회의실배정_1931_sharpie1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] timeTable = new int[N][2];
        for (int i = 0; i < N; i++) {
            timeTable[i][0] = sc.nextInt();
            timeTable[i][1] = sc.nextInt();
        }

        timeTable = Arrays.stream(timeTable)
                .sorted(Comparator.comparingInt((int[] time) -> time[1])
                        .thenComparingInt(time -> time[0]))
                .toArray(int[][]::new);

        int answer = 0;
        int endTime = 0;

        for (int[] time : timeTable) {
            if (endTime <= time[0]) {
                endTime = time[1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}

