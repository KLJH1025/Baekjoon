package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20115 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] list = new long[n];
        for(int i=0; i<n; i++){
            list[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(list);

        double d = 0.0;
        for(int i=0; i<n-1; i++){
            d += (double)list[i] / 2;
        }
        d += list[n-1];
        System.out.printf("%.5f", d);
    }
}
