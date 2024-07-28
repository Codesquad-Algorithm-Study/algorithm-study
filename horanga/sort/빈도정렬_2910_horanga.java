package horanga.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 빈도정렬_2910_horanga {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new LinkedHashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());

        for(int i =0; i<n; i++){
            String num = st.nextToken();
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        for(int i =0; i<list.size(); i++){
            String key = list.get(i);
            Integer value = map.get(key);
            for(int j =0; j<value; j++){
                System.out.print(key+ " ");
            }
        }

    }
}
