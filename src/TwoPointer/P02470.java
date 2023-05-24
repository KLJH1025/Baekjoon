package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P02470 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] list = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(list);
        int start = 0;
        int end = n-1;

        long minValue = Long.MAX_VALUE;
        long leftValue = 0;
        long rightValue = 0;

        while(start < end){
            long sum = Math.abs(list[start] + list[end]);
            if(sum < minValue){
                minValue = sum;
                leftValue = list[start];
                rightValue = list[end];
            }

            if(list[start] > 0){
                end--;
            }
            else if(list[end] < 0){
                start++;
            }
            else{
                if(Math.abs(list[start]) > Math.abs(list[end])){
                    start++;
                }
                else{
                    end--;
                }
            }
        }

        System.out.println(leftValue + " " + rightValue);

    }
}
