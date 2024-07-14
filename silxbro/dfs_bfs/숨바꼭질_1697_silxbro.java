package silxbro.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class 숨바꼭질_1697_silxbro {

    static int[] time;
    static int start, end;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        start = scanner.nextInt();
        end = scanner.nextInt();

        time = new int[100001];
        Arrays.fill(time, Integer.MAX_VALUE);

        time[start] = 0;
        bfs(start);

        System.out.println(time[end]);
    }

    private static void bfs(int position) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(position);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now - 1 >= 0 && time[now - 1] == Integer.MAX_VALUE) {
                time[now - 1] = time[now] + 1;
                queue.add(now - 1);
            }
            if (now + 1 < time.length && time[now + 1] == Integer.MAX_VALUE) {
                time[now + 1] = time[now] + 1;
                queue.add(now + 1);
            }
            if (now * 2 < time.length && time[now * 2] == Integer.MAX_VALUE) {
                time[now * 2] = time[now] + 1;
                queue.add(now * 2);
            }
        }
    }
}
