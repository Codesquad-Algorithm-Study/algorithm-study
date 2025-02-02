package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399_sharpie1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }

        sc.close();

        Arrays.sort(P);

        int answer = 0;
        for (int i = N; i > 0; i--) {
            answer += i * P[N - i];
        }

        System.out.println(answer);
    }
}
