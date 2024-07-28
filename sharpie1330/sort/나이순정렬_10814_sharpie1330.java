package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Member {
    int age;
    String name;
    int order;

    Member(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }
}

public class 나이순정렬_10814_sharpie1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            members.add(new Member(age, name, i));
        }

        members.sort((m1, m2) -> {
            if (m1.age != m2.age) {
                return m1.age - m2.age;
            } else {
                return m1.order - m2.order;
            }
        });

        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }
}
