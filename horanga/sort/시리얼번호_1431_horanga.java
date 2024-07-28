package horanga.sort;

import java.util.Arrays;
import java.util.Scanner;

public class 시리얼번호_1431_horanga {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            String[] arr = new String[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.next();
            }

            Arrays.sort(arr, (o1, o2) -> {
                if (o1.length() == o2.length()) {
                    int sum1 = 0;
                    int sum2 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) <= '9' && o1.charAt(i) >= '0') {
                            sum1 += o1.charAt(i)-'0';
                        }
                    }
                    for (int i = 0; i < o2.length(); i++) {
                        if (o2.charAt(i) <= '9' && o2.charAt(i) >= '0') {
                            sum2 += o2.charAt(i)-'0';
                        }
                    }
                    if (sum1 == sum2)
                        return o1.compareTo(o2);
                    else
                        return sum1 - sum2;
                } else {
                    return o1.length() - o2.length();
                }
            });

            for (int i = 0; i < N; i++) {
                System.out.println(arr[i]);
            }
        }
    }
