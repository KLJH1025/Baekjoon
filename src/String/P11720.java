package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11720 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] list = br.readLine().toCharArray();
        int total = 0;
        for(int i=0; i<n; i++){
            total += (list[i] - '0');
        }
        System.out.println(total);
    }
}
