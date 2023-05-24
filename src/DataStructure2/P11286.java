package DataStructure2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P11286 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)){
                    return o1-o2;
                }
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                if(priorityQueue.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    sb.append(priorityQueue.poll()).append("\n");
                }
            }
            else{
                priorityQueue.add(temp);
            }
        }
        System.out.println(sb);
    }
}
