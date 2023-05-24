package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P13975 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            long m = Long.parseLong(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
            for(int j=0; j<m; j++){
                priorityQueue.add(Long.parseLong(st.nextToken()));
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
}
