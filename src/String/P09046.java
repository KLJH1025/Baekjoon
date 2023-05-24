package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class P09046 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        char[] origin = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] password = "wghuvijxpqrstacdebfklmnoyz".toCharArray();

        for(int i=0; i<n; i++){
            char[] input = scan.nextLine().toCharArray();

            String answer = "";
            int max = 0;
            HashMap<Character, Integer> hashMap = new HashMap<>();

            for(int j=0; j<input.length; j++){
                if(input[j] >= 'a' && input[j] <= 'z'){
                    hashMap.put(input[j], hashMap.getOrDefault(input[j], 0) + 1);
                    max = Math.max(max, hashMap.get(input[j]));
                }
            }

            for(char c : hashMap.keySet()){
                if(hashMap.get(c) == max){
                    answer += c;
                }
            }
            if(answer.length() == 1)
                System.out.println(answer);
            else System.out.println("?");
        }

    }
}
