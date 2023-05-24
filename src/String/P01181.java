package String;

import java.util.*;

public class P01181 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else{
                    return o1.length() - o2.length();
                }
            }
        });
        for(int i=0; i<n; i++){
            String a = scan.next();
            treeSet.add(a);
        }

        for(String s : treeSet){
            System.out.println(s);
        }
    }
}
