package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Box implements Comparable<Box>{
    int end;
    int volume;
    Box(int end, int volume){
        this.end = end;
        this.volume = volume;
    }

    @Override
    public int compareTo(Box o){
        if(this.end == o.end){
            return this.volume - o.volume;
        }
        return this.end - o.end;
    }
}
public class P08980 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int house_number = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Box> priorityQueue = new PriorityQueue<>();
        ArrayList<Box>[] boxList = new ArrayList[n+1];
        for(int i=0; i<=n+1; i++){
            boxList[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int volume = Integer.parseInt(st.nextToken());
            boxList[start].add(new Box(end, volume));
        }

        for(int i=1; i<n+1; i++){

        }
    }
}
