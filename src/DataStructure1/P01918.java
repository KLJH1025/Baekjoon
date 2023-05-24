package DataStructure1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class calculate{
    char symbol;
    int priority;

    calculate(char symbol, int priority){
        this.symbol = symbol;
        this.priority = priority;
    }
}

public class P01918 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray();

        Queue<Character> alphabetQueue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<input.length; i++){
            if(input[i] >= 'A' && input[i] <= 'Z'){
                alphabetQueue.add(input[i]);
            }
            else if(input[i] == '+'){

            }
            else if(input[i] == '-'){

            }
            else if(input[i] == '*'){
                stack.add(input[i]);
            }
            else if(input[i] == '/'){
                stack.add(input[i]);
            }
            else if(input[i] == '('){

            }
            else if(input[i] == ')'){

            }
        }

    }
}
