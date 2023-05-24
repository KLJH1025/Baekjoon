package Greedy;

import java.util.*;
import java.io.*;

public class P02212 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=1; i<n; i++){
            arrayList.add(list[i] - list[i-1]);
        }
        Collections.sort(arrayList);

        int answer = 0;
        for(int i=0; i<n-m; i++){
            answer += arrayList.get(i);
        }
        System.out.println(answer);


    }
}
