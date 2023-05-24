package Math;

import java.util.Scanner;

public class P01978 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        for(int i=0; i<n; i++){
            int temp = scan.nextInt();
            if(check(temp)) count++;
        }
        System.out.println(count);
    }
    public static boolean check(int num){
        int count = 0;
        for(int i=1; i<= num/2; i++){
            if(num % i == 0){
                count++;
            }
        }
        if(count == 1){
            return true;
        }
        return false;
    }
}
