package horanga.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 단어정렬_1181_horanga {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        String[] array = new String[n];
        for(int i =0; i<n ;i++){
            array[i]=bufferedReader.readLine();
        }

        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if(o1.length()== o2.length()){
                    return o1.compareTo(o2);
                } else {
                    return o1.length()-o2.length();
                }
            }
        });

        System.out.println(array[0]);

        for (int i = 1; i < n; i++) {
            // 중복되지 않는 단어만 출력
            if (!array[i].equals(array[i - 1])) {
                System.out.println(array[i]);
            }
        }
    }
}
