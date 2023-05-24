package Tree;

import java.util.*;
import java.io.*;

public class P14675 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arrayLists = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arrayLists[i] = new ArrayList<>();
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            arrayLists[n1].add(n2);
            arrayLists[n2].add(n1);
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if(n1 == 2) sb.append("yes\n");
            else{
                int count = 0;
                for(int temp : arrayLists[n2]){
                    count++;
                }

                if(count >= 2){
                    sb.append("yes\n");
                }
                else{
                    sb.append("no\n");
                }
            }
        }

        System.out.println(sb);
    }
}
