package String;

import java.util.Scanner;

public class P11365 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp = "";
        while(!(temp = scanner.nextLine()).equals("END")){
            StringBuilder sb = new StringBuilder();
            for(int i = temp.length()-1; i>=0; i--){
                sb.append(temp.charAt(i));
            }
            System.out.println(sb);
        }
    }
}
