package String;

import java.util.*;
import java.io.*;

public class P17413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        char[] answer = new char[input.length];
        int start = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<input.length; i++){
            if(input[i] == ' '){ // 공백을 만나면
                while(!stack.isEmpty()){
                    answer[start++] = stack.pop();
                }
                answer[start++] = ' ';
            }
            else if(input[i] == '<'){ // < 를 만나면
                if(!stack.isEmpty()){ // stack에 뭐 있으면 뒤집어서 출력 먼저
                    while(!stack.isEmpty()){
                        answer[start++] = stack.pop();
                    }
                }
                while(input[i] != '>'){ // > 를 만날때까지 그대로 출력
                    answer[start++] = input[i];
                    i++;
                }
                answer[start++] = input[i];
            }
            else{ // 이외의 문자는 stack에 넣어놓는다.
                stack.add(input[i]);
            }
        }

        if(!stack.isEmpty()){ // stack에 뭐 남아있으면 뒤집어서 출력
            while(!stack.isEmpty()){
                answer[start++] = stack.pop();
            }
        }

        for(char c : answer){
            System.out.print(c);
        }
    }
}