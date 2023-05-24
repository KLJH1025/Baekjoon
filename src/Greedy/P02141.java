package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class House implements Comparable<House>{
    long pos;
    long person;
    House(long pos, long person){
        this.pos = pos;
        this.person = person;
    }

    @Override
    public int compareTo(House o){
        if(this.pos == o.pos){
            if(this.person < o.person){
                return -1;
            }
            else{
                return 1;
            }
        }
        else{
            if(this.pos < o.pos){
                return -1;
            }
            else{
                return 1;
            }
        }
    }

}
public class P02141 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<House> arrayList = new ArrayList<>();
        long total = 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long pos = Long.parseLong(st.nextToken());
            long person = Long.parseLong(st.nextToken());
            total += person;
            arrayList.add(new House(pos, person));
        }
        Collections.sort(arrayList);

        long count = 0;
        for(House h : arrayList){
            count += h.person;
            if(count >= (total+1)/2){
                System.out.println(h.pos);
                break;
            }
        }

    }
}
