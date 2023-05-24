package String;

import java.util.Scanner;

public class P20154 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] input = scan.next().toCharArray();

        int[] list = {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};

        int sum = 0;
        for(int i=0; i<input.length; i++){
            sum += list[input[i] - 'A'];
        }

        if(sum % 2 == 0){
            System.out.println("You're the winner?");
        }
        else{
            System.out.println("I'm a winner!");
        }
    }
}
