package GraphTraversal;

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
        int[] answer = new int[n+1];
        ArrayList<Integer>[] arrayList = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arrayList[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arrayList[n1].add(n2);
            arrayList[n2].add(n1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        answer[1] = 1000;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int k : arrayList[temp]){
                if(answer[k] == 0){
                    queue.add(k);
                    answer[k] = temp;
                }
            }
        }

        for(int i=2; i<=n; i++){
            System.out.println(answer[i]);
        }
    }
}
