package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] distance = new long[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            distance[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long answer = 0;
        long min = Long.MAX_VALUE;
        for(int i=0; i<n-1; i++){
            min = Math.min(min, Long.parseLong(st.nextToken()));
            answer += min*distance[i];
        }
        System.out.println(answer);
    }
}
