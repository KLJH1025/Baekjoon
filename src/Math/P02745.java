package Math;

import java.util.Scanner;

public class P02745 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] list = scan.next().toCharArray();
        int n = scan.nextInt();

        int sum = 0;
        int mul = 1;
        for(int i=list.length-1; i>=0; i--){
            if(list[i] >= '0' && list[i] <= '9'){
                sum += (list[i] - '0') * mul;
            }
            else{
                sum += (list[i] - 'A' + 10) * mul;
            }
            mul *= n;
        }

        System.out.println(sum);
    }
}
