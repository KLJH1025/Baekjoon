package GraphTraversal;

import java.util.*;
import java.io.*;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class P02178{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];
        boolean[][] check = new boolean[row][col];
        for(int i=0; i<row; i++){
            String temp = br.readLine();
            for(int j=0; j<col; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        check[0][0] = true;

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0; i<len; i++) {
                Point p = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = p.x + dx[j];
                    int nextY = p.y + dy[j];
                    if(nextY < 0 || nextY >= row || nextX < 0 || nextX >= col)
                        continue;

                    if(check[nextY][nextX] == true || map[nextY][nextX] == 0)
                        continue;

                    check[nextY][nextX] = true;
                    queue.add(new Point(nextX, nextY));
                    map[nextY][nextX] = map[p.y][p.x] + 1;
                }
            }
        }

        System.out.println(map[row-1][col-1]);
    }
}