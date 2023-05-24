package DataStructure1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Document implements Comparable<Document> {
    int index;
    int important;
    public Document(int index, int important){
        this.index = index;
        this.important = important;
    }

    @Override
    public int compareTo(Document o) {
        return this.important - o.important;
    }
}
public class P01966 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            Queue<Document> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            int[] values = new int[len];
            for(int j=0; j<len; j++){
                int value = Integer.parseInt(st.nextToken());
                values[j] = value;
                queue.add(new Document(j, value));
            }
            Arrays.sort(values);
            int point = len-1;

            int count = 1;
            while(true){
                Document d = queue.poll();
                if(d.important == values[point]){
                    if(d.index == pos){
                        sb.append(count).append("\n");
                        break;
                    }
                    else{
                        count++;
                        point--;
                    }
                }
                else{
                    queue.add(d);
                }
            }
        }
        System.out.println(sb);
    }
}
