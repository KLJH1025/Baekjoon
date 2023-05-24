package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P04659 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while(!((input = br.readLine()).equals("end"))){
            boolean flag = false;
            for(int i=0; i<input.length(); i++){
                if(input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' ||
                        input.charAt(i) == 'o' || input.charAt(i) == 'u'){
                    flag = true;
                }
                if(i < input.length()-2 && (checkMo(input.charAt(i)) == checkMo(input.charAt(i+1))) &&
                        (checkMo(input.charAt(i+2)) == checkMo(input.charAt(i+1)))){
                    flag = false;
                    break;
                }
                if(i < input.length()-1 && input.charAt(i) == input.charAt(i+1) && input.charAt(i) != 'e' && input.charAt(i) != 'o'){
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.printf("<%s> is acceptable.\n", input);
            else System.out.printf("<%s> is not acceptable.\n", input);
        }
    }
    public static boolean checkMo(char c){
        if(c == 'a' || c == 'o' || c == 'i' || c == 'u' || c == 'e'){
            return true;
        }
        return false;
    }
}
