package DataStructure1;

import java.util.ArrayList;
import java.util.Scanner;

public class P10828 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            String a = scan.next();
            if(a.equals("push")){
                int temp = scan.nextInt();
                list.add(temp);
            }
            else if(a.equals("pop")){
                if(list.size() == 0)
                    sb.append("-1\n");
                else{
                    int temp = list.get(list.size()-1);
                    list.remove(list.size() - 1);
                    sb.append(temp).append("\n");
                }
            }
            else if(a.equals("size")){
                sb.append(list.size()).append("\n");
            }
            else if(a.equals("empty")){
                if(list.size() == 0)
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }
            else{
                int len = list.size()-1;
                if(len == -1)
                    sb.append("-1\n");
                else
                    sb.append(list.get(len)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
