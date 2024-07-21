package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 로프_2217_sharpie1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
        }

        Arrays.sort(weights);

        for (int i = 0; i < N; i++) {
            weights[i] = weights[i] * (N - i);
        }

        Arrays.sort(weights);

        System.out.println(weights[N - 1]);
    }
}
