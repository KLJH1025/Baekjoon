package Tree;

import java.io.*;
import java.util.*;

public class P17073 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[n+1];
        ArrayList<Integer>[] arrayLists = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arrayLists[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arrayLists[u].add(v);
            arrayLists[v].add(u);
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();

            boolean flag = false;
            for(int v : arrayLists[temp]){
                if(visit[v] == false){
                    queue.add(v);
                    visit[v] = true;
                    flag = true;
                }
            }
            if(!flag) count++;
        }

        if(count>0) System.out.println((double)m/count);
        else System.out.println(0);
    }
}
