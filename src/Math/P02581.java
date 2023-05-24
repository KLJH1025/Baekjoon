package Math;

import java.util.Scanner;

public class P02581 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int min = 0;
        int sum = 0;
        for(int i=n; i<=m; i++){
            if(check(i)){
                if(sum == 0){
                    min = i;
                    sum += i;
                }
                else{
                    sum += i;
                }
            }
        }
        if(sum == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
    public static boolean check(int num){
        int count = 0;
        for(int i=1; i<=num/2; i++){
            if(num%i == 0){
                count++;
            }
        }
        if(count == 1)
            return true;
        return false;
    }
}
