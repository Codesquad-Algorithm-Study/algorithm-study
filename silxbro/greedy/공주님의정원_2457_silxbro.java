package silxbro.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 공주님의정원_2457_silxbro {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] flowers = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            flowers[i][0] = getDayOfYear(startMonth, startDay);
            flowers[i][1] = getDayOfYear(endMonth, endDay);
        }

        // 꽃이 피는 날짜 기준으로 오름차순 정렬 후, 지는 날짜 기준으로 내림차순 정렬
        // 구간이 더 긴 꽃을 선택하기 위함
        Arrays.sort(flowers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });

        int startDay = getDayOfYear(3, 1);
        int endDay = getDayOfYear(11, 30);

        int index = 0;
        int count = 0;
        int maxEndDay = 0;

        while (startDay <= endDay && index < N) {
            boolean found = false;
            // 현재 고려 중인 날짜 범위(startDay, endDay)에서
            // startDay 이전에 피는 꽃 중 가장 지는 날짜가 늦은 꽃을 선택
            while (index < N && flowers[index][0] <= startDay) {
                if (flowers[index][1] > maxEndDay) {
                    maxEndDay = flowers[index][1];
                    found = true;
                }
                index++;
            }

            if (!found) {
                count = 0;
                break;
            }

            // 날짜 범위 업데이트 (startDay를 업데이트함으로써, 범위를 줄여나감)
            startDay = maxEndDay;
            count++;
        }


        // 꽃이 피는 시기가 계속 이어졌으나, 11/30까지 지속되지 못한 경우
        if (startDay <= endDay) {
            count = 0;
        }

        System.out.println(count);
    }

    private static int getDayOfYear(int month, int day) {
        // 각 월의 일 수
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 해당 월까지의 일 수를 합산
        int dayOfYear = 0;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonth[i];
        }
        dayOfYear += day;

        return dayOfYear;
    }
}
