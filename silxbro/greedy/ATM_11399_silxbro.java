package silxbro.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399_silxbro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] P = new int[N];
        int[] S = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = scanner.nextInt();
        }

        // 돈을 인출하는 데 걸리는 시간이 적은 순서로 정렬 ---> 각 인출시간 최소화
        Arrays.sort(P);

        S[0] = P[0];
        int sum = S[0];

        for (int i = 1; i< N; i++) {
            S[i] = S[i - 1] + P[i];
            sum += S[i];
        }

        System.out.println(sum);
    }
}
