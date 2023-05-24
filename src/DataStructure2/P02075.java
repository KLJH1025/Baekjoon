package DataStructure2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;
    int data;
    Point(int x, int y, int data){
        this.x = x;
        this.y = y;
        this.data = data;
    }
}

public class P02075 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o2.data - o1.data;
            }
        });

        for(int i=0; i<n; i++){
            priorityQueue.add(new Point(i, n-1, map[n-1][i]));
        }

        for(int i=0; i<n-1; i++){
            Point temp = priorityQueue.poll();
            int x = temp.x;
            int y = temp.y;
            priorityQueue.add(new Point(x, y-1, map[y-1][x]));
        }

        System.out.println(priorityQueue.peek().data);

    }
}
