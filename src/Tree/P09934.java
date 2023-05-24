package Tree;

import java.util.*;
import java.io.*;

public class P09934 {

    static int N;
    static StringBuilder[] sb;
    static int[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder[N];
        for(int i=0; i<N; i++){
            sb[i] = new StringBuilder();
        }
        String[] strList = br.readLine().split(" ");
        list = new int[strList.length];
        for(int i=0; i< strList.length; i++){
            list[i] = Integer.parseInt(strList[i]);
        }

        func(0, list.length-1, 0);

        for(int i=0; i<N; i++){
            System.out.println(sb[i]);
        }

    }

    public static void func(int start, int end, int depth){
        if(depth == N){

        }
        else{
            int mid = (start + end) / 2;
            sb[depth].append(list[mid]).append(" ");

            func(start, mid-1, depth+1);
            func(mid+1, end, depth+1);
        }
    }
}
