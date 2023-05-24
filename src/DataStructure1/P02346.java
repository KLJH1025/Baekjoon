package DataStructure1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Balloon{
    int num;
    int value;
    public Balloon(int num, int value){
        this.num = num;
        this.value = value;
    }
}
public class P02346 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] list = new int[n];

        ArrayList<Balloon> arrayList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
            arrayList.add(new Balloon(i+1, list[i]));
        }

        int point = 0;
        while(arrayList.size() != 1){
            Balloon b = arrayList.get(point);
            sb.append(b.num).append(" ");
            arrayList.remove(point);

            if(b.value >= 0){
                point += b.value-1;
                while(point >= arrayList.size()){
                    point -= arrayList.size();
                }
            }
            else{
                point += b.value;
                while(point < 0){
                    point += arrayList.size();
                }
            }
        }
        sb.append(arrayList.get(0).num);
        System.out.println(sb);
    }
}
