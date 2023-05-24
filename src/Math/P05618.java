package Math;

import java.util.Scanner;

public class P05618{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] list = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            list[i] = scan.nextInt();
            min = Math.min(min, list[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<= min; i++){
            boolean flag = true;
            for(int j=0; j<n; j++){
                if(list[j] % i != 0){
                    flag = false;
                    break;
                }
            }
            if(flag)
                sb.append(i).append("\n");
        }

        System.out.println(sb);
    }


}
