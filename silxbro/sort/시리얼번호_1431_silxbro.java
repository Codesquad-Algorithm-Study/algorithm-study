package silxbro.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 시리얼번호_1431_silxbro {

    public static void main(String[] args) {
        // 우선순위 큐 생성 (for 정렬)
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length() && sumOfNumbers(o1) == sumOfNumbers(o2)) {
                    return o1.compareTo(o2);
                }
                if (o1.length() == o2.length()) {
                    return sumOfNumbers(o1) - sumOfNumbers(o2);
                }
                return o1.length() - o2.length();
            }
        });

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int num = 0; num < count; num++) {
            pq.add(scanner.next());
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    private static int sumOfNumbers(String target) {
        // 알파벳 제거
        String temp = target.replaceAll("[^1-9]", "");
        int sum = 0;
        for (char c : temp.toCharArray()) {
            // 0의 char 값을 빼주면 해당 char의 숫자값 계산 가능
            sum += c - '0';
        }
        return sum;
    }
}
