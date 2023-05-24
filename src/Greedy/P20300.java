package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20300 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] list = new long[n];
        for(int i=0; i<n; i++){
            list[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(list);

        long answer = 0;
        if(n == 1){
            answer = list[0];
        }
        else if(n % 2 == 0){
            for(int i=0; i<n/2; i++){
                answer = Math.max(answer, list[i] + list[n-1-i]);
            }
        }
        else{
            answer = list[n-1];
            for(int i=0; i<(n-1)/2; i++){
                answer = Math.max(answer, list[i] + list[n-2-i]);
            }
        }
        System.out.println(answer);
    }
}
