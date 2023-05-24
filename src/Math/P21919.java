package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P21919 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 1;
        int max = 0;
        int[] list = new int[n];
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, list[i]);
        }

        boolean[] check = new boolean[max+1];
        check[0] = true;
        check[1] = true;
        for(int i=2; i<=max; i++){
            for(int j=i*2; j<=max; j+=i){
                if(check[j] == false){
                    check[j] = true;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(check[list[i]] == false){
                sum = sum * list[i];
                check[list[i]] = true;
            }
        }

        if(sum == 1){
            System.out.println(-1);
        }
        else{
            System.out.println(sum);
        }
    }
}
