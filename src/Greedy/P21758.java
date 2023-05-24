package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21758 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[n];
        int[] subSum = new int[n];
        list[0] = Integer.parseInt(st.nextToken());
        subSum[0] = list[0];
        for(int i=1; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
            subSum[i] = subSum[i-1] + list[i];
        }

        int max = 0;
        //벌벌꿀
        for(int i=1; i<=n-2; i++){
            int temp1 = subSum[n-1] - list[0] - list[i];
            int temp2 = subSum[n-1] - subSum[i];
            max = Math.max(max, temp1+temp2);
        }
        //System.out.println("벌벌꿀 = " + max);

        //벌꿀벌
        int tmp = 0;
        for(int i=1; i<=n-2; i++){
            tmp = Math.max(tmp, list[i]);
        }
        max = Math.max(max, tmp+subSum[n-2]-list[0]);
        //System.out.println("벌꿀벌 = " + max);


        //꿀벌벌
        for(int i=1; i<=n-2; i++){
            int temp1 = subSum[n-1] - list[n-1] - list[n-1-i];
            int temp2 = subSum[n-2-i];
            max = Math.max(max, temp1+temp2);
        }
        //System.out.println("꿀벌벌 = " + max);

        System.out.println(max);
    }
}
