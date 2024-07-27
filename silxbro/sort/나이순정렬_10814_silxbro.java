package silxbro.sort;

import java.util.Arrays;
import java.util.Scanner;

public class 나이순정렬_10814_silxbro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Member[] members = new Member[N];
        for (int i = 0; i < N; i++) {
            members[i] = new Member(i, scanner.nextInt(), scanner.next());
        }

        Arrays.sort(members);

        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }


    static class Member implements Comparable<Member> {
        int order;
        int age;
        String name;

        Member(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age == o.age) {
                return this.order - o.order;
            }
            return this.age - o.age;
        }
    }
}
