package horanga.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 역원소정렬_5648_horanga {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        while(st.hasMoreTokens()){
            list.add(reverse(st.nextToken()));
        }


        String str ="";
        while((str = br.readLine()) != null){
            st = new StringTokenizer(str);
            while(st.hasMoreTokens()){
                list.add(reverse(st.nextToken()));
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i)+"\n");
        }
        System.out.println(sb.toString());

    }

    static long reverse(String num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        return Long.parseLong(sb.reverse().toString());
    }
}
