package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 역원소정렬_5648_seedspirit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 맨 첫 줄 맨 첫번째 원소는 전체 원소의 갯수이다
        int n = Integer.parseInt(st.nextToken());
        String[] numbersStr = new String[n];
        long[] numbers = new long[n];
        int i = 0;
        
        // 만약 저장한 원소의 갯수가 첫번째 원소의 갯수와 같으면 그만한다
        // st.nextToken의 결과 값이 null일때까지 st.nextToken을 한다
        // st.nextToken의 결과 값이 Null이라면 br.readline을 하고 위 과정을 반복한다
        while(i < n){
            while(st.hasMoreTokens()){
                String s = st.nextToken();
                numbersStr[i] = s;
                i += 1;
            }
            if(i < n){
                st = new StringTokenizer(br.readLine());
            }
        }

        // 저장한 원소 각각에 대해 for 문을 돈다
          // 원소의 뒤집어 접근한다
          // StringBuilder로 하나하나 쌓아간다
          // 만약 StringBuilder에 원소가 하나도 없고 넣어야 하는게 0이라면 건너뛴다
          // 만약 원소가 0이 아니거나 0이더라도 2번째 원소부터라면 넣는다
        
        for(int j=0; j<n; j++){
            String number = numbersStr[j];
            StringBuilder sb = new StringBuilder();
            for(int k=number.length()-1; k>-1; k--){
                char t = number.charAt(k);
                if(sb.length() == 0 && t == '0'){
                    continue;
                }
                sb.append(t);
            }
            numbers[j] = Long.parseLong(sb.toString());
        }
        
        // 오름차순으로 정렬한다
        Arrays.sort(numbers);
       
        
        // 결과를 println한다
        for(long l: numbers){
            System.out.println(l);
        } 
    }
}
