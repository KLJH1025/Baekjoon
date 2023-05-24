package GraphTraversal;

import java.io.*;
import java.util.*;

public class P02667 {
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n;
    static int[][] map;
    static ArrayList<Integer> answers = new ArrayList<>();
    public static int BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        int count = 1;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n){
                    if(map[nextX][nextY] == 1) {
                        queue.add(new Point(nextX, nextY));
                        map[nextX][nextY] = 0;
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    map[i][j] = 0;
                    int returnBFS = BFS(i,j);
                    answers.add(returnBFS);
                }
            }
        }

        System.out.println(answers.size());
        Collections.sort(answers);
        if(answers.size() != 0 ) {
            for (int i : answers) {
                System.out.println(i);
            }
        }
    }
}
