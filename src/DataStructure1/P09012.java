package DataStructure1;

import java.util.Scanner;
import java.util.Stack;

public class P09012 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scan.nextInt();
        for(int i=0; i<n; i++){
            char[] list = scan.next().toCharArray();
            Stack<Character> stack = new Stack<>();
            String answer = "YES";
            for(int j=0; j<list.length; j++){
                if(list[j] == '('){
                    stack.add(list[j]);
                }
                else{
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }
                    else {
                        answer = "NO";
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) answer = "NO";
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
