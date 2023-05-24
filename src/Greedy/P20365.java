package Greedy;

import java.util.Scanner;

public class P20365 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        char[] list = scan.next().toCharArray();
        int redCount = 0;
        int blueCount = 0;
        boolean red = false;
        boolean blue = false;

        for(int i=0; i<list.length; i++){
            if(list[i] == 'R'){
                if(red == true) continue;
                else{
                    red = true;
                    blue = false;
                    redCount++;
                }
            }
            else if(list[i] == 'B'){
                if(blue == true) continue;
                else{
                    red = false;
                    blue = true;
                    blueCount++;
                }
            }
        }
        if(redCount > blueCount){
            System.out.println(blueCount + 1);
        }
        else{
            System.out.println(redCount + 1);
        }
    }
}
