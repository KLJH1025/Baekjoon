package DataStructure1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P01935 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] list = st.nextToken().toCharArray();
        int[] nums = new int[n+1];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Double> stack = new Stack<>();
        for(int i=0; i<list.length; i++){
            if(list[i] >= 'A' && list[i] <= 'Z'){
                stack.add((double)nums[list[i] - 'A']);
            }
            else if(list[i] == '+'){
                double temp1 = stack.pop();
                double temp2 = stack.pop();
                stack.push(temp1+temp2);
            }
            else if(list[i] == '-'){
                double temp1 = stack.pop();
                double temp2 = stack.pop();
                stack.push(temp2-temp1);
            }
            else if(list[i] == '*'){
                double temp1 = stack.pop();
                double temp2 = stack.pop();
                stack.push(temp1*temp2);
            }
            else if(list[i] == '/'){
                double temp1 = stack.pop();
                double temp2 = stack.pop();
                stack.push(temp2/temp1);
            }
            /*
            System.out.print("<stack" + i + "> ");
            for(double d : stack){
                System.out.print(d + " ");
            }
            System.out.println();
            */
        }
        System.out.printf("%.2f\n", stack.peek());
    }
}
