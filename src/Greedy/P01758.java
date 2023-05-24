package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P01758 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            //list[i] = Integer.parseInt(br.readLine());
            arrayList.add(Integer.parseInt(br.readLine()));
        }
        //Arrays.sort(list);
        Collections.sort(arrayList, Collections.reverseOrder());
        long answer = 0;
        for(int i=0; i<n; i++){
            //int temp = list[n-1-i] - i;
            int temp = arrayList.get(i) - i;
            if(temp > 0){
                answer += temp;
            }
        }
        System.out.println(answer);
    }
}
