package silxbro.greedy;

import java.util.Scanner;

public class 동전0_11047_silxbro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // 동전 종류의 갯수
        int K = scanner.nextInt();  // 지불하고자 하는 금액 총액

        int[] A = new int[N];
        for (int num = 0; num < N; num++) {
            A[num] = scanner.nextInt();
        }

        int answer = 0;
        for (int num = N-1; num >= 0; num--) {
            // 각 동전의 가치가 서로 배수 관계이므로 그리디 적용 가능
            // 동전의 가치가 큰 것부터 순회 ---> 동전의 갯수 최소
            answer += K / A[num];
            K %= A[num];
        }
        System.out.println(answer);
    }
}
