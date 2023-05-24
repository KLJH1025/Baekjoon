package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class C implements Comparable<C>{
    int start;
    int end;
    C(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(C o){
        if(this.start == o.start){
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}

public class P11000 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        C[] list = new C[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[i] = new C(start, end);
        }
        Arrays.sort(list);
        for(C c : list){
            System.out.println(c.start + " " + c.end);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(list[0].end);

        for(int i=1; i<n; i++){
            if(priorityQueue.peek() <= list[i].start){
                priorityQueue.poll();
            }
            priorityQueue.add(list[i].end);
        }
        System.out.println(priorityQueue.size());
    }
}
