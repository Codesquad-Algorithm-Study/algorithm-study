package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 시리얼번호_1431_sharpie1330 {
    public static void main(String[] args) {

        // A와 B가 길이가 다르면 짧은 게 먼저
        // 같으면 A의 모든 자리수 합과 B의 모든 자리수 합을 비교해 작은 합을 가지는 것이 먼저
        // 만약 1,2번으로도 비교 불가라면 사전순(숫자가 알파벳보다 사전순으로 작음)

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        String[] serials = new String[N];
        for (int i = 0; i < N; i++) {
            serials[i] = sc.nextLine();
        }

        List<String> serialStrings = Arrays.stream(serials).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }

                int sum1 = serialNumSum(o1);
                int sum2 = serialNumSum(o2);
                if (sum1 != sum2) {
                    return sum1 - sum2;
                }

                return o1.compareTo(o2);
            }
        }).collect(Collectors.toList());

        for (String s : serialStrings) {
            System.out.println(s);
        }
    }

    public static int serialNumSum(String serialNum) {
        int sum = 0;
        for (int i = 0; i < serialNum.length(); i++) {
            if(!Character.isDigit(serialNum.charAt(i))) {
                continue;
            }
            sum += Integer.parseInt(String.valueOf(serialNum.charAt(i)));
        }

        return sum;
    }
}
