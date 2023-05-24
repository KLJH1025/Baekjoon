package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P01747 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int MAX = 1003001;

        boolean[] list = new boolean[MAX+1];
        list[0] = true;
        list[1] = true;
        for(int i=2; i<=Math.sqrt(MAX); i++){
            for(int j=i*2; j<=MAX; j+=i){
                list[j] = true;
            }
        }

        for(int i=n; i<=MAX; i++){
            if(list[i] == false && check(i)){
                System.out.println(i);
                break;
            }
        }
    }
    public static boolean check(int n){
        String temp = String.valueOf(n);
        for(int i=0; i<temp.length()/2; i++){
            if(temp.charAt(i) != temp.charAt(temp.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
