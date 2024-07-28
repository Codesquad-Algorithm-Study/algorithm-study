package sort;

import java.util.*;

public class 카드_11652_sharpie1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<Long, Integer> cards = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Long card = sc.nextLong();
            if (cards.containsKey(card)) {
                cards.put(card, cards.get(card) + 1);
            } else {
                cards.put(card, 1);
            }
        }

        Long key = 0L;
        int value = 0;
        for (Map.Entry<Long, Integer> entry : cards.entrySet()) {
            if (entry.getValue() > value) {
                key = entry.getKey();
                value = entry.getValue();
            } else if (entry.getValue() == value) {
                key = Math.min(key, entry.getKey());
            }
        }

        System.out.println(key);
    }
}
