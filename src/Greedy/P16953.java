package Greedy;

import java.util.Scanner;

public class P16953 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int count = 1;
        while(m > n){
            if(m % 10 == 1){
                m = m / 10;
                count++;
            }
            else if(m % 10 % 2 == 0){
                m = m / 2;
                count++;
            }
            else{
                count = -1;
                break;
            }
        }
        if(m == n)
            System.out.println(count);
        else System.out.println(-1);
    }
}
