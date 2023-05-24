package DataStructure1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P02504 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        Stack<Character> charStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        for(int i=0; i<input.length; i++){
            char c = input[i];

            if(c == '(' || c == '['){
                charStack.add(c);
            }
            else if( c == ')' ){
                int total = 0;
                while(true){
                    if(charStack.isEmpty()){
                        System.out.println("0");
                        return;
                    }
                    char cc = charStack.pop();
                    if(cc == '('){
                        if(total == 0){
                            numStack.add(2);
                        }
                        else numStack.add(total * 2);
                        charStack.add('N');
                        break;
                    }
                    else if(cc == 'N'){
                        total += numStack.pop();
                    }
                    else{
                        System.out.println("0");
                        return;
                    }
                }
            }
            else if( c == ']' ){
                int total = 0;
                while(true){
                    if(charStack.isEmpty()){
                        System.out.println("0");
                        return;
                    }
                    char cc = charStack.pop();
                    if(cc == '['){
                        if(total == 0){
                            numStack.add(3);
                        }
                        else numStack.add(total * 3);
                        charStack.add('N');
                        break;
                    }
                    else if(cc == 'N'){
                        total += numStack.pop();
                    }
                    else{
                        System.out.println("0");
                        return;
                    }
                }
            }
            else{
                System.out.println("0");
                return;
            }

            /*
            System.out.println("=============");
            System.out.print("charStack : ");
            for(char x : charStack){
                System.out.print(x + " ");
            }
            System.out.println();
            System.out.print("numStack : ");
            for(int x : numStack){
                System.out.print(x + " ");
            }
            System.out.println();
            */

        }

        int answer = 0;
        for(int i : numStack){
            answer += i;
        }
        if(charStack.contains('(') || charStack.contains(')') || charStack.contains('[') || charStack.contains(']'))
            System.out.println("0");
        else
            System.out.println(answer);

    }
}
