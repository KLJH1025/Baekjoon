package GraphTraversal;

import java.io.*;
import java.util.*;


public class P01325 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arrayLists = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arrayLists[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayLists[b].add(a);
        }

        int[] answer = new int[n+1];
        int max = 0;

        for(int i=1; i<=n; i++){
            boolean[] check = new boolean[n+1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            check[i] = true;
            while(!queue.isEmpty()){
                int temp = queue.poll();
                for(int next : arrayLists[temp]){
                    if(check[next] == false){
                        check[next] = true;
                        queue.add(next);
                    }
                }
            }

            for(boolean b : check){
                if(b) answer[i]++;
            }
            max = Math.max(max, answer[i]);
        }

        for(int i=1; i<=n; i++){
            if(answer[i] == max){
                System.out.print(i + " ");
            }
        }
    }
}
