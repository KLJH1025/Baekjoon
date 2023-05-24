package String;

import java.util.Scanner;

public class P03029 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] start = scan.next().split(":");
        String[] end = scan.next().split(":");

        int[] s = new int[3];
        int[] e = new int[3];
        for(int i=0; i<3; i++){
            s[i] = Integer.parseInt(start[i]);
            e[i] = Integer.parseInt(end[i]);
        }

        int[] result = new int[3];
        for(int i=0; i<3; i++){
            result[i] = e[i] - s[i];
        }

        if(result[2] < 0){
            result[1] -= 1;
            result[2] += 60;
        }
        if(result[1] < 0){
            result[0] -= 1;
            result[1] += 60;
        }
        if(result[0] < 0){
            result[0] += 24;
        }

        if(result[0] == 0 && result[1] == 0 && result[2] == 0){
            System.out.println("24:00:00");
            return;
        }

        System.out.printf("%02d", result[0]);
        System.out.print(":");
        System.out.printf("%02d", result[1]);
        System.out.print(":");
        System.out.printf("%02d", result[2]);
    }
}
