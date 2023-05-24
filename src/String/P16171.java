package String;

import java.util.Scanner;

public class P16171 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        char[] input = scan.next().toCharArray();
        for(int i=0; i<input.length; i++){
            if((input[i] >= 'a' && input[i] <= 'z') ||
                    (input[i] >= 'A' && input[i] <= 'Z')){
                sb.append(input[i]);
            }
        }
        String find = scan.next();

        if(sb.toString().contains(find)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}
