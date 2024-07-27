package silxbro.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 카드_11652_silxbro {

    public static void main(String[] args) {
        Map<Long, Long> countMap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        int numberOfCards = scanner.nextInt();
        for (int i = 0; i < numberOfCards; i++) {
            long nowNumber = scanner.nextLong();
            // 각 숫자의 개수 count
            countMap.put(nowNumber, countMap.getOrDefault(nowNumber, 0L) + 1);
        }

        // (카드의 숫자, count) entry 정렬
        List<Map.Entry<Long, Long>> entryList = new ArrayList<>(countMap.entrySet());
        entryList.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return Long.compare(o1.getKey(), o2.getKey());
            }
            return Long.compare(o2.getValue(), o1.getValue());
        });

        System.out.println(entryList.get(0).getKey());
    }
}