package Greedy;

import java.io.*;
import java.util.*;

class Room implements Comparable<Room>{
    int start;
    int end;
    Room(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room o){
        if(this.start == o.start){
            return this.end - o.end;
        }
        return this.start - o.start;
    }

}

public class P19598 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Room[] list = new Room[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[i] = new Room(start, end);
        }
        Arrays.sort(list);

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
