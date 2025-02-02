package yonghyeonpark.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전0_11047_yonghyeonpark {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            int coin = coins[i];
            if (k / coin > 0) {
                count += k / coin;
                k %= coin;
            }
            if (k == 0) break;
        }

        System.out.println(count);
    }
}
