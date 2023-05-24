package Greedy;

import java.util.Scanner;

public class P01343 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        String ans = "";
        String A = "AAAA", B = "BB";

        s = s.replaceAll("XXXX", A);
        ans = s.replaceAll("XX", B);

        if(ans.contains("X")) {
            ans = "-1";
        }

        System.out.println(ans);
    }
}
