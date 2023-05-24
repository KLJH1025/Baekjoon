package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11399 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[n];
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int answer = list[0];

        int[] subList = new int[n];
        subList[0] = list[0];
        for(int i=1 ;i<n; i++){
            subList[i] = subList[i-1] + list[i];
            answer += subList[i];
        }
        System.out.println(answer);
    }
}
