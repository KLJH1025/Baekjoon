package Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11725 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] arrayLists = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arrayLists[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            arrayLists[node1].add(node2);
            arrayLists[node2].add(node1);
        }

        int[] answer = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int k : arrayLists[temp]){
                if(answer[k] == 0) {
                    answer[k] = temp;
                    queue.add(k);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++){
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);

    }
}
