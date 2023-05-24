package GraphTraversal;

import java.util.*;
import java.io.*;

public class P14940 {
    static int R, C;
    static int[][] map;
    static int[][] answerMap;
    static boolean[][] check;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C){
                    continue;
                }
                if(map[nextX][nextY] != 1 || check[nextX][nextY] == true){
                    continue;
                }

                map[nextX][nextY] = map[p.x][p.y] + 1;
                check[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY));
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        answerMap = new int[R][C];
        check = new boolean[R][C];

        int startX = 0;
        int startY = 0;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    startX = i;
                    startY = j;
                }
            }
        }

        map[startX][startY] = 0;
        check[startX][startY] = true;
        BFS(startX, startY);

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == 1 && check[i][j] == false){
                    map[i][j] = -1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
