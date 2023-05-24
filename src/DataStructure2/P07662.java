package DataStructure2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P07662 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for(int j=0; j<m; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(a.equals("I")){
                    treeMap.put(num, treeMap.getOrDefault(num, 0)+1);
                }
                else if(a.equals("D")){
                    if(treeMap.isEmpty()){
                        continue;
                    }
                    if(num == 1){
                        int maxKey = treeMap.lastKey();
                        if(treeMap.get(maxKey) == 1){
                            treeMap.remove(maxKey);
                        }
                        else{
                            treeMap.put(maxKey, treeMap.get(maxKey)-1);
                        }
                    }
                    else if(num == -1){
                        int minKey = treeMap.firstKey();
                        if(treeMap.get(minKey) == 1){
                            treeMap.remove(minKey);
                        }
                        else{
                            treeMap.put(minKey, treeMap.get(minKey)-1);
                        }
                    }
                }
            }
            if(treeMap.isEmpty()){
                sb.append("EMPTY\n");
            }
            else{
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
            }
        }
        System.out.println(sb);

    }
}
