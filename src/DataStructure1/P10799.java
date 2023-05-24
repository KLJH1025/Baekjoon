package DataStructure1;

import java.util.Scanner;
import java.util.Stack;

public class P10799 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.next();
        char[] list = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        int steel = 0;
        int total = 0;
        for(int i=0; i<list.length; i++){
            if(list[i] == '('){
                if(list[i+1] == ')'){
                    total += steel;
                    i++;
                }
                else {
                    steel++;
                    stack.add('(');
                }
            }
            else if(list[i] == ')'){
                total += 1;
                steel -= 1;
            }
        }
        System.out.println(total);

    }
}
