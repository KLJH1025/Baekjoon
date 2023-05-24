import java.util.*;
import java.io.*;

public class DFS_TEST {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int row, col;
    static char[][] map;
    static boolean[][] check;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            map = new char[row][col];
            check = new boolean[row][col];

            for (int x = 0; x < row; x++) {
                String temp = br.readLine();
                for (int y = 0; y < col; y++) {
                    map[x][y] = temp.charAt(y);
                    check[x][y] = false;
                }
            }

            HashSet<Character> hashSet = new HashSet<>();
            hashSet.add(map[0][0]);
            answer = Math.max(answer, hashSet.size());
            check[0][0] = true;

            for(int m=0; m<4; m++){
                int nextX = 0 + dx[m];
                int nextY = 0 + dy[m];
                if(check(nextX, nextY, hashSet)){
                    DFS(nextX, nextY, hashSet);
                }
            }

            System.out.println("#" + i + " " + answer);
        }
    }

    public static void DFS(int visitX, int visitY, HashSet<Character> nextHashSet){
        //check[visitX][visitY] = true;
        nextHashSet.add(map[visitX][visitY]);

        answer = Math.max(answer, nextHashSet.size());

        for(int m=0; m<4; m++){
            int nextX = visitX + dx[m];
            int nextY = visitY + dy[m];
            if(check(nextX, nextY, nextHashSet)){
                DFS(nextX, nextY, nextHashSet);
            }
        }

        //check[visitX][visitY] = false;
        nextHashSet.remove(map[visitX][visitY]);
    }

    public static boolean check(int nextX, int nextY, HashSet<Character> nextHashSet){
        if(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col
                 && !nextHashSet.contains(map[nextX][nextY])){
            return true;
        }
        return false;
    }
}