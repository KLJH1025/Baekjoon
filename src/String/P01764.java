package String;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class P01764 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> answer = new TreeSet<>();
        for(int i=0; i<n; i++){
            String temp = scan.next();
            hashSet.add(temp);
        }
        for(int i=0; i<m; i++){
            String temp = scan.next();
            if(hashSet.contains(temp)){
                answer.add(temp);
            }
        }
        System.out.println(answer.size());
        for(String s : answer){
            System.out.println(s);
        }
    }
}
