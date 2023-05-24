package String;

import java.util.Scanner;

public class P10798 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] map = new char[5][];
        int maxLen = 0;
        for(int i=0; i<5; i++){
            map[i] = scan.next().toCharArray();
            maxLen = Math.max(maxLen, map[i].length);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<maxLen; i++) {
            for (int j = 0; j < 5; j++) {
                if(map[j].length > i){
                    sb.append(map[j][i]);
                }
            }
        }
        System.out.println(sb);
    }
}
