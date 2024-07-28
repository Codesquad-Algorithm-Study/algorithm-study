package sort;

import java.io.*;
import java.util.*;

public class 시리얼_1431_seedspirit {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] guitars = new String[N];
        for(int i=0; i<N; i++){
            guitars[i] = br.readLine();
        }

        Arrays.sort(guitars, new Comparator<>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()){
                    if(sum(s1) == sum(s2)){
                        return s1.compareTo(s2);
                    }
                    return sum(s1) - sum(s2);
                }
                return s1.length() - s2.length();
            }
        });

        for(String guitar : guitars){
            System.out.println(guitar);
        }
    }

    public static int sum(String s){
        int result = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                result += c - '0';
            }
        }
        return result;
    }
    
}