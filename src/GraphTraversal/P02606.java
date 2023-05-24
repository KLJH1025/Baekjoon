package GraphTraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P02606 {
    static ArrayList<Integer>[] arrayLists;
    static boolean[] check;
    static int n;
    public static void DFS(int n){
        if(check[n]){
            return;
        }
        else{
            check[n] = true;
            for(int k : arrayLists[n]){
                DFS(k);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        check = new boolean[n+1];
        arrayLists = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arrayLists[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            arrayLists[com1].add(com2);
            arrayLists[com2].add(com1);
        }
        DFS(1);

        int count = 0;
        for(int i=2; i<=n; i++){
            if(check[i]) count++;
        }
        System.out.println(count);
    }
}
