package sort;

import java.util.*;

public class 빈도정렬_2910_sharpie1330 {
    static class Element {
        int value;
        int frequency;
        int firstIndex;

        Element(int value, int frequency, int firstIndex) {
            this.value = value;
            this.frequency = frequency;
            this.firstIndex = firstIndex;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] sequence = new int[N];

        for (int i = 0; i < N; i++) {
            sequence[i] = sc.nextInt();
        }

        Map<Integer, Element> freqMap = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            int num = sequence[i];
            if (freqMap.containsKey(num)) {
                freqMap.get(num).frequency++;
            } else {
                freqMap.put(num, new Element(num, 1, i));
            }
        }

        List<Element> elements = new ArrayList<>(freqMap.values());
        elements.sort((e1, e2) -> {
            if (e1.frequency != e2.frequency) {
                return e2.frequency - e1.frequency;
            } else {
                return e1.firstIndex - e2.firstIndex;
            }
        });

        StringBuilder result = new StringBuilder();
        for (Element e : elements) {
            for (int i = 0; i < e.frequency; i++) {
                result.append(e.value).append(" ");
            }
        }

        System.out.println(result.toString().trim());
    }
}
