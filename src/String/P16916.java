package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P16916 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        for(int i=0; i<a.length - b.length + 1; i++){
            boolean flag = true;
            for(int j=0; j<b.length; j++){
                if(a[i+j] != b[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
