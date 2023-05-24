package DataStructure1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
class Point{
    int index;
    int value;
    Point(int index, int value){
        this.index = index;
        this.value = value;
    }
}
public class P02493 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Point> stack = new Stack<>();
        int[] answer = new int[n+1];

        for(int i=1; i<=n; i++){
            int value = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()){
                stack.add(new Point(i, value));
            }
            else if(stack.peek().value < value){
                while(!stack.isEmpty()){
                    Point p = stack.peek();
                    if(p.value < value){
                        stack.pop();
                    }
                    else if(p.value > value){
                        answer[i] = p.index;
                        break;
                    }
                }
                stack.add(new Point(i, value));
            }
            else if(stack.peek().value > value){
                answer[i] = stack.peek().index;
                stack.add(new Point(i, value));
            }
        }


        for(int i=1; i<=n; i++){
            System.out.print(answer[i] + " ");
        }

    }
}
