package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14916 {
    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int five_count = n / 5;
        int two_count = n % 5;

        while(five_count >= 0){
            if(two_count % 2 == 0){
                System.out.println(five_count + two_count/2);
                return;
            }
            else{
                five_count -= 1;
                two_count += 5;
            }
        }
        System.out.println(-1);


    }
}
