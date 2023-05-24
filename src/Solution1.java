import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(queue.size() > 1){
            sb.append(queue.poll()).append(" ");
            queue.add(queue.poll());
        }
        sb.append(queue.poll());
        System.out.println(sb);

    }
}
