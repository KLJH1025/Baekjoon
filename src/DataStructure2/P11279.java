package DataStructure2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11279 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            return o2-o1;
        });
        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                if(priorityQueue.isEmpty())
                    System.out.println("0");
                else System.out.println(priorityQueue.poll());
            }
            else{
                priorityQueue.add(temp);
            }
        }
    }
}
