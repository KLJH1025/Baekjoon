package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11508 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int repeat = n / 3;
        int answer = 0;
        for(int i=0; i<repeat; i++){
            answer += list[n-1 - (i*3)];
            answer += list[n-2 - (i*3)];
        }
        for(int i=0; i< n -(repeat*3); i++){
            answer += list[i];
        }

        System.out.println(answer);

    }
}
