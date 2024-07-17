package silxbro.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 회의실배정_1931_silxbro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] M = new int[N][2];

        for (int n = 0; n < N; n++) {
            M[n][0] = scanner.nextInt();
            M[n][1] = scanner.nextInt();
        }

        Arrays.sort(M, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 현재 회의의 종료 시간이 빠를수록, 다음 회의와 겹치지 않는 데 유리
                // 종료시간이 빠른 순서대로 정렬, 종료 시간이 같을 경우 시작시간 기준 정렬
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int end = -1;   // 종료 시간 초기화
        for (int n = 0; n < N; n++) {
            // 겹치지 않는 회의일 경우, 카운트 및 종료 시간 업데이트
            if (M[n][0] >= end) {
                count++;
                end = M[n][1];
            }
        }
        System.out.println(count);
    }
}