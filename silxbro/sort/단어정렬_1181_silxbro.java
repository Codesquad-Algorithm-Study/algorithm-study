package silxbro.sort;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class 단어정렬_1181_silxbro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        // 정렬 및 중복 방지 --> set 자료구조 사용
        Set<String> words = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        for (int i = 0; i < number; i++) {
            words.add(scanner.next());
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}