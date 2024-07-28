package greedy;

import java.util.*;

public class 동전0_11047_sharpie1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] V = new int[N];
        for (int i = 0; i < N; i++) {
            V[i] = sc.nextInt();
        }

        int answer = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (K / V[i] == 0) {
                continue;
            }
            answer += K / V[i];
            K = K % V[i];
        }

        System.out.println(answer);
    }
}