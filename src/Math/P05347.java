package Math;

import java.util.Scanner;

public class P05347 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scan.nextInt();
        for(int i=0; i<n; i++){
            long a = scan.nextLong();
            long b = scan.nextLong();
            long result = 0;
            if(a>b){
                result = Euclid(a,b);
            }
            else{
                result = Euclid(b,a);
            }
            sb.append(a*b/result).append("\n");
        }
        System.out.println(sb);
    }

    public static long Euclid(long big, long small){
        long A = big;
        long B = small;
        while(true){
            long temp = A % B;
            if(temp == 0){
                break;
            }
            else{
                A = B;
                B = temp;
            }
        }
        return B;
    }
}
