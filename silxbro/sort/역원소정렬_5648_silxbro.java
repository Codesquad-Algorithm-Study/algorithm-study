package silxbro.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 역원소정렬_5648_silxbro {

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            String reversed = new StringBuilder(scanner.next()).reverse().toString();
            list.add(Long.parseLong(reversed));
        }

        Collections.sort(list);

        list.forEach(System.out::println);
    }
}