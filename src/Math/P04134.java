package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P04134 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            long a = Long.parseLong(br.readLine());
            BigInteger b = new BigInteger(String.valueOf(a));
            if(b.isProbablePrime(10)){
                sb.append(a).append("\n");
            }
            else{
                sb.append(b.nextProbablePrime()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
