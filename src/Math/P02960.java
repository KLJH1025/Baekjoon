package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02960 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] list = new boolean[n+1];

        int count = 0;
        for(int i=2; i<=n; i++){
            for(int j=i; j<=n; j+=i){
                if(list[j] == false){
                    list[j] = true;
                    count++;
                }
                if(count == k){
                    System.out.println(j);
                    return;
                }
            }
        }

    }
}
