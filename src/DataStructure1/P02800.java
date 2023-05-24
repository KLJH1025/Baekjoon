package DataStructure1;

import java.util.*;
import java.io.*;

class Pair{
    int left;
    int right;
    Pair(int left, int right){
        this.left = left;
        this.right = right;
    }
}
public class P02800{
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<Pair> arrayList = new ArrayList<>();
    static boolean[] check;
    static String input;
    static TreeSet<String> answer = new TreeSet<>();
    public static void DFS(int index, int depth){
        if(depth == arrayList.size()){
            ArrayList<Integer> indexes = new ArrayList<>();
            for(int i=0; i<check.length; i++){
                if(check[i] == true){
                    indexes.add(arrayList.get(i).left);
                    indexes.add(arrayList.get(i).right);
                }
            }
            Collections.sort(indexes);

            StringBuilder sb = new StringBuilder();
            int indexPointer = 0;
            for(int i=0; i<input.length(); i++){
                if(indexPointer < indexes.size() && indexes.get(indexPointer) == i){
                    indexPointer++;
                }
                else{
                    sb.append(input.charAt(i));
                }
            }
            answer.add(sb.toString());
        }
        else{
            for(int i = index; i < check.length; i++){
                check[i] = true;
                DFS(i+1, depth+1);
                check[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        input = scan.next();

        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == '('){
                stack.add(i);
            }
            else if(input.charAt(i) == ')'){
                arrayList.add(new Pair(stack.pop(), i));
            }
        }

        check = new boolean[arrayList.size()];

        for(int i=0; i<check.length; i++){
            DFS(0, i);
        }

        for(String s : answer){
            System.out.println(s);
        }
    }
}