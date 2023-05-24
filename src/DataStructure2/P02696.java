package DataStructure2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P02696 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append(m/2+1).append("\n");

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            if(m <= 10){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1; j<=m; j++){
                    int temp = Integer.parseInt(st.nextToken());
                    if(maxHeap.size() == minHeap.size()){
                        maxHeap.add(temp);
                    }
                    else{
                        minHeap.add(temp);
                    }

                    if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
                        int temp1 = maxHeap.poll();
                        int temp2 = minHeap.poll();

                        minHeap.add(temp1);
                        maxHeap.add(temp2);
                    }

                    if(j%2 == 1){
                        sb.append(maxHeap.peek()).append(" ");
                    }
                }
            }
            else{
                while(m >= 10){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for(int j=1; j<=10; j++){
                        int temp = Integer.parseInt(st.nextToken());
                        if(maxHeap.size() == minHeap.size()){
                            maxHeap.add(temp);
                        }
                        else{
                            minHeap.add(temp);
                        }

                        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
                            int temp1 = maxHeap.poll();
                            int temp2 = minHeap.poll();

                            minHeap.add(temp1);
                            maxHeap.add(temp2);
                        }

                        if(j%2 == 1){
                            sb.append(maxHeap.peek()).append(" ");
                        }
                    }

                    m -= 10;
                }
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1; j<=m; j++){
                    int temp = Integer.parseInt(st.nextToken());
                    if(maxHeap.size() == minHeap.size()){
                        maxHeap.add(temp);
                    }
                    else{
                        minHeap.add(temp);
                    }

                    if(maxHeap.peek() > minHeap.peek()){
                        int temp1 = maxHeap.poll();
                        int temp2 = minHeap.poll();

                        minHeap.add(temp1);
                        maxHeap.add(temp2);
                    }

                    if(j%2 == 1){
                        sb.append(maxHeap.peek()).append(" ");
                    }
                }
            }

            System.out.println(sb);
        }
    }
}
