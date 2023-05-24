package DataStructure1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P02164 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            queue.add(i+1);
        }

        while(queue.size() != 1){
            queue.poll();
            if(queue.size() == 1)
                break;
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());

    }
}
