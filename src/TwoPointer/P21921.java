package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class P21921 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int count = 1;
        int maxValue = 0;
        int sum = 0;

        for(int i=0; i<m; i++){
            sum += list[i];
        }
        maxValue = sum;

        for(int i=m; i<n; i++){
            sum += list[i];
            sum -= list[i-m];
            //System.out.print(sum + " ");

            if(maxValue < sum){
                maxValue = sum;
                count = 1;
            }
            else if(maxValue == sum){
                count += 1;
            }
        }
        if(maxValue == 0){
            System.out.println("SAD");
        }
        else{
            System.out.println(maxValue);
            System.out.println(count);
        }
    }
}
