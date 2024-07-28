package sort;

import java.util.Arrays;
import java.util.Scanner;

public class 역원소정렬_5648_sharpie1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] nums = new long[n];

        for (int i = 0; i < n; i++) {
            String num = String.valueOf(sc.nextLong());
            String[] numSplit = num.split("");
            for (int j = 0; j < num.length() / 2; j++) {
                String temp = numSplit[j];
                numSplit[j] = numSplit[numSplit.length - j - 1];
                numSplit[numSplit.length - j - 1] = temp;
            }
            String reduce = Arrays.stream(numSplit).reduce("", (a, b) -> a + b);
            nums[i] = Long.parseLong(reduce);
        }

        long[] array = Arrays.stream(nums).sorted().toArray();
        for (long a : array) {
            System.out.println(a);
        }
    }
}
