package horanga.greedy;

import java.util.Scanner;

public class 동전0_11047_horanga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] coins = new int[n];

        for(int i =0; i<n; i++){
            coins[i] = scanner.nextInt();
        }

        int count=0;

        for(int i = n-1; i>=0; i--){
            if(coins[i]<=k){
                count += (k/coins[i]);
                k %= coins[i];
            }
        }

        System.out.println(count);
    }
}
