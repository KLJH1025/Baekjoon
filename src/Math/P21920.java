package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21920 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        long sum = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            if(func(x, list[i]) == 1){
                sum += list[i];
                count += 1;
            }
        }

        System.out.println(sum / count);
    }

    public static int func(int a, int b){
        int A = a;
        int B = b;
        if(a < b){
            A = b;
            B = a;
        }

        while(true){
            int temp = A % B;
            if(temp == 0){
                break;
            }
            else{
                A = B;
                B = temp;
            }
        }
        return B;
    }
}
