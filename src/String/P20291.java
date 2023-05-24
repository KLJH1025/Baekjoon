package String;

import java.util.*;

public class P20291 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for(int i=0; i<n; i++){
            String a = scanner.next();
            int index = a.indexOf('.');
            a = a.substring(index+1);
            treeMap.put(a, treeMap.getOrDefault(a, 0) + 1);
        }
        for(String s : treeMap.keySet()){
            System.out.println(s + " " + treeMap.get(s));
        }
    }
}
