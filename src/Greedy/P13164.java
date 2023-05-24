package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P13164 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] list = new int[n];
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=1; i<n; i++){
            arrayList.add(list[i] - list[i-1]);
        }
        Collections.sort(arrayList);

        int answer = 0;
        for(int i=0; i < n-m; i++){
            answer += arrayList.get(i);
        }

        System.out.println(answer);

    }
}
