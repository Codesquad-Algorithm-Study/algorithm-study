package silxbro.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 빈도정렬_2910_silxbro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> orderMap = new HashMap<>();

        int N = scanner.nextInt();  //숫자 등장 횟수
        int C = scanner.nextInt();  //최대 숫자

        for (int i = 0; i < N; i++) {
            int number = scanner.nextInt();
            if (!orderMap.containsKey(number)) {
                orderMap.put(number, i);
            }
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        List<Node> nodes = new ArrayList<>();
        for (Integer number : orderMap.keySet()) {
            nodes.add(new Node(number, orderMap.get(number), countMap.get(number)));
        }

        Collections.sort(nodes);

        for (Node node : nodes) {
            System.out.print((node.value + " ").repeat(node.count));
        }
    }

    static class Node implements Comparable<Node> {
        int value;
        int order;
        int count;

        public Node(int value, int order, int count) {
            this.value = value;
            this.order = order;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if (this.count == o.count) {
                return this.order - o.order;
            }
            return o.count - this.count;
        }
    }

}

