package silxbro.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 보물_1026_silxbro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }

        // 최솟값을 구하려면 최댓값일수록 최소, 최소일수록 최대의 반복수만큼 더해야 한다는 점을 고려
        // A 배열을 더하는 값, B 배열을 각 A 배열을 더하는 반복수라고 생각했을 때 A와 B의 정렬 방향이 반대가 되어야 함
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += A[i] * B[i];
        }

        System.out.println(answer);
    }
}
