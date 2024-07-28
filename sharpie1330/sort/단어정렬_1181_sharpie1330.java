package sort;

import java.util.*;

public class 단어정렬_1181_sharpie1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            wordSet.add(sc.nextLine().trim());
        }

        List<String> words = new ArrayList<>(wordSet);
        words.sort((a, b) -> compareWord(a, b));

        for (String word : words) {
            System.out.println(word);
        }
    }

    public static int compareWord(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() - b.length();
        } else {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    return a.charAt(i) - b.charAt(i);
                }
            }
            return 0;
        }
    }
}
