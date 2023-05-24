package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());

        int[] list = new int[n];
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i=n-1; i>=0; i--){
            count += price / list[i];
            price = price % list[i];
        }

        System.out.println(count);

    }
}
