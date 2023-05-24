package Math;

import java.util.Scanner;

public class P01934 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0; i<n; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();

            int c = Math.min(a,b);
            int gongyak = 0;
            for(int j=1; j<=c; j++){
                if(a%j == 0 && b%j == 0){
                    gongyak = j;
                }
            }
            System.out.println(gongyak * (a/gongyak) * (b/gongyak));
        }
    }
}
