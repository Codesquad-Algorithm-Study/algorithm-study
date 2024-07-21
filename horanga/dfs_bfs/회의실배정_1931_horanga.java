package horanga.dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class 회의실배정_1931_horanga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            time[i][0] = scanner.nextInt();
            time[i][1] = scanner.nextInt();
        }

        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });
        int count = 0;
        int prevEndTime = 0;

        for (int i = 0; i < N; i++) {
            if (prevEndTime <= time[i][0]) {
                prevEndTime = time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
