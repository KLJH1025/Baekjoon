package GraphTraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P01260 {

    static ArrayList<Integer>[] arrayLists;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNumber = Integer.parseInt(st.nextToken());
        int queryNumber = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[nodeNumber+1];
        check = new boolean[nodeNumber+1];
        for(int i=1; i<=nodeNumber; i++){
            arrayLists[i] = new ArrayList<>();
        }

        for(int i=0; i<queryNumber; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            arrayLists[node1].add(node2);
            arrayLists[node2].add(node1);
        }
        for(int i=1; i<=nodeNumber; i++){
            Collections.sort(arrayLists[i]);
        }

        DFS(start);
        sb.append("\n");
        check = new boolean[nodeNumber+1];

        BFS(start);

        System.out.println(sb);
    }

    public static void DFS(int node){
        if(check[node] == true){
            return;
        }
        else{
            check[node] = true;
            sb.append(node).append(" ");
            for(int a : arrayLists[node]){
                if(check[a] == false)
                    DFS(a);
            }
        }
    }
    public static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        check[node] = true;

        while(!queue.isEmpty()){
            int temp = queue.poll();
            sb.append(temp).append(" ");
            for(int a : arrayLists[temp]){
                if(check[a] == false){
                    check[a] = true;
                    queue.add(a);
                }
            }
        }
    }
}
