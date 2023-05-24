package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P20210 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][];
        for(int i=0; i<n; i++){
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

    }
}
