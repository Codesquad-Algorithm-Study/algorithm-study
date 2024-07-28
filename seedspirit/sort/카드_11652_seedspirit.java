package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 카드_11652_seedspirit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> cards = new HashMap<>();
        
        // 가장 많이 가지고 있는 요소와, 그것의 갯수를 초기화한다
        long maxKey = 0;
        int maxValue = 0;
        
        int value = 0;
        
        for(int i=0; i<N; i++){
            // map을 확인해 없는 요소라면 1, 있는 요소라면 기존 것 + 1을 한다
            long key = Long.parseLong(br.readLine());
            cards.put(key, cards.getOrDefault(key, 0) + 1);
            
            // 업데이트 후 이번에 업데이트한 요소의 갯수가 가장 많이 가지고 있는 요소보다 크면 업데이트 한다
            value = cards.get(key);
            if((value > maxValue) || (value == maxValue && key < maxKey)){
                maxKey = key;
                maxValue = value;
            }            
        }
        
        System.out.println(maxKey);
    }
}
