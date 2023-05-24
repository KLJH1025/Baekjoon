package Greedy;

import java.util.Scanner;

public class P01541 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        int sum = 0;
        String[] splitMinus = input.split("-");
        for(int i=0; i< splitMinus.length; i++){
            String[] splitPlus = splitMinus[i].split("\\+");
            int subSum = 0;
            for(int j=0; j<splitPlus.length; j++){
                subSum += Integer.parseInt(splitPlus[j]);
            }
            if(i == 0){
                sum += subSum;
            }
            else{
                sum -= subSum;
            }
        }
        System.out.println(sum);

    }
}
