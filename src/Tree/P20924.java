package Tree;

import java.io.*;
import java.util.*;

public class P20924 {

    static int N, R;
    static ArrayList<Node>[] arrayLists;

    static boolean[] visit;
    static int centerLength, maxLength;
    static int nextStart;

    static class Node{
        int data;
        int length;
        Node(int data, int length){
            this.data = data;
            this.length = length;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            arrayLists[i] = new ArrayList<>();
        }
        visit = new boolean[N+1];

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            arrayLists[a].add(new Node(b,d));
            arrayLists[b].add(new Node(a,d));
        }

        findCenterLength(R, 0);
        findMaxLength(new Node(nextStart, 0));

        System.out.println(centerLength + " " + maxLength);
    }

    public static void findCenterLength(int nodeNum, int sum){

        visit[nodeNum] = true;

        int count = 0;
        int nextNum = 0;
        int nextSum = 0;
        for(Node n : arrayLists[nodeNum]){
            if(visit[n.data] == false){
                count++;
                nextNum = n.data;
                nextSum = n.length;
            }
        }

        if(count == 1){
            findCenterLength(nextNum, sum + nextSum);
        }
        else{
            centerLength = sum;
            nextStart = nodeNum;
        }

    }

    public static void findMaxLength(Node n){

        Queue<Node> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()){
            Node getOne = queue.poll();
            if(arrayLists[getOne.data].size() == 1){
                maxLength = Math.max(maxLength, getOne.length + arrayLists[getOne.data].get(0).length);
            }
            for(Node nn : arrayLists[getOne.data]){
                if(visit[nn.data] == false){
                    visit[nn.data] = true;
                    nn.length += n.length;
                    queue.add(nn);
                }
            }
        }

    }
}