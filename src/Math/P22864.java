package Math;

import java.util.Scanner;

public class P22864 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int m = scan.nextInt();

        int tired = 0;
        int answer = 0;
        for(int i=0; i<24; i++){
            if(tired + a <= m){
                tired += a;
                answer += b;
            }
            else{
                tired -= c;
                if(tired < 0){
                    tired = 0;
                }
            }
        }
        System.out.println(answer);
    }
}
