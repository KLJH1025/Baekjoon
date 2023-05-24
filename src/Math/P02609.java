package Math;

import java.util.Scanner;

public class P02609 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = Math.min(a,b);
        int min = 0;

        for(int i=1; i<=c; i++){
            if(a%i == 0 && b%i == 0){
                min = Math.max(min, i);
            }
        }

        System.out.println(min);
        System.out.println(min * (a/min) * (b/min));

    }
}
