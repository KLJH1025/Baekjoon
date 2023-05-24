package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P17609 {
    static char[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            list = br.readLine().toCharArray();
            if (check(0, list.length-1)) {
                System.out.println(0);
            }
            else if(check2(0, list.length-1)){
                System.out.println(1);
            }
            else{
                System.out.println(2);
            }
        }

    }
    public static boolean check(int start, int end){
        while(start < end){
            if(list[start] != list[end]){
                return false;
            }
            else{
                start += 1;
                end -= 1;
            }
        }
        return true;
    }

    public static boolean check2(int start, int end){
        while(start < end){
            if(list[start] != list[end]){
                boolean flag1 = check(start+1, end);
                boolean flag2 = check(start, end-1);
                if(flag1 || flag2)
                    return true;
                return false;
            }
            else{
                start += 1;
                end -= 1;
            }
        }
        return true;
    }
}
