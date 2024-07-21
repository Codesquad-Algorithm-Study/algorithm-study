package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 보물_1026_sharpie1330{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        // 가장 작게 만들려면 B의 가장 큰 값과 A의 가장 작은 값들을 곱해야 한다.
        for (int i = 0; i < N; i++) {
            int max = i;
            for (int j = N - 1; j > i; j--) {
                if(B[max] < B[j]){
                    max = j;
                }
            }
            int temp = B[max];
            B[max] = B[i];
            B[i] = temp;
        }

        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[i];
        }
        System.out.println(S);

        sc.close();
    }
}
