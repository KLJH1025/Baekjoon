package Math;

import java.util.Scanner;

public class P11653 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n==1) return;

        StringBuilder sb = new StringBuilder();
        int value = 2;
        while(n > 1){
            if(n % value == 0){
                sb.append(value).append("\n");
                n = n / value;
            }
            else{
                value += 1;
            }
        }
        System.out.println(sb);
    }
}
