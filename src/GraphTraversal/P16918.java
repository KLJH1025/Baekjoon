package GraphTraversal;
import java.util.*;
import java.io.*;

public class P16918 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        int[][] time = new int[R][C];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for(int i=0; i<R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }


        for(int i=1; i<=L; i++){
            if(i == 1){
                for(int x=0; x<R; x++){
                    for(int y=0; y<C; y++){
                        if(map[x][y] == 'O'){
                            time[x][y] = 2;
                        }
                    }
                }
            }
            else if(i == 2){
                for(int x=0; x<R; x++){
                    for(int y=0; y<C; y++){
                        if(time[x][y] == 2){
                            time[x][y] = 1;
                        }
                        else{
                            time[x][y] = 2;
                            map[x][y] = 'O';
                        }
                    }
                }
            }
            else if(i == 3){
                for(int x=0; x<R; x++){
                    for(int y=0; y<C; y++){
                        if(time[x][y] == 2){
                            time[x][y] = 1;
                        }
                        else{
                            time[x][y] = 2;
                            map[x][y] = 'O';
                        }
                    }
                }
            }
        }


        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
}
