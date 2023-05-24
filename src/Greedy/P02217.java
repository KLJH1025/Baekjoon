package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02217 {
    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int weight = -1;
        int[] list = new int[n];
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);

        for(int i=0; i<n; i++){
            weight = Math.max(weight, list[i] * (n-i));
        }
        System.out.println(weight);
    }
}
