package Math;

import java.util.Scanner;

public class P01110 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int count = 0;
        int goal = n;
        while(true){
            count++;
            int temp = (n / 10) + (n % 10);
            n = (n % 10) * 10 + (temp % 10);
            if(goal == n){
                break;
            }
        }

        System.out.println(count);
    }
}
