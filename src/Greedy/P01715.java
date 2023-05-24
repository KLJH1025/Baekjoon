package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P01715 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            priorityQueue.add(Long.parseLong(br.readLine()));
        }
        long sum = 0;
        while(priorityQueue.size() > 1){
            long temp1 = priorityQueue.poll();
            long temp2 = priorityQueue.poll();
            sum += (temp1 + temp2);
            priorityQueue.add(temp1 + temp2);
        }
        System.out.println(sum);
    }
}
