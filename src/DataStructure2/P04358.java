package DataStructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P04358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        HashMap<String, Integer> hashMap = new HashMap<>();
        int total_count = 0;
        while((input = br.readLine()) != null){
            total_count++;
            hashMap.put(input, hashMap.getOrDefault(input,0)+1);
        }

        ArrayList<String> arrayList = new ArrayList<>();
        for(String s : hashMap.keySet()){
            arrayList.add(s);
        }
        Collections.sort(arrayList);

        for(String s : arrayList){
            sb.append(s).append(" ");
            sb.append(String.format("%.4f", (double)hashMap.get(s) *100.0/ (double)total_count));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
