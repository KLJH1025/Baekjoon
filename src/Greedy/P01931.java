package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Reservation implements Comparable<Reservation>{
    int start;
    int end;
    public Reservation(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Reservation o){
        if(this.end == o.end){
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}

public class P01931 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Reservation[] list = new Reservation[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[i] = new Reservation(start, end);
        }
        Arrays.sort(list);

        int count = 0;
        int end_time = 0;
        for(int i=0; i<n; i++){
            if(end_time <= list[i].start){
                end_time = list[i].end;
                count++;
            }
        }
        System.out.println(count);
    }
}
