package DataStructure2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P01620 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] list = new String[n+1];
        for(int i=0; i<n; i++){
            String name = br.readLine();
            hashMap.put(name, i+1);
            list[i+1] = name;
        }

        for(int i=0; i<m; i++){
            String a = br.readLine();
            if(a.matches("^[0-9]*$")){
                System.out.println(list[Integer.parseInt(a)]);
            }
            else{
                System.out.println(hashMap.get(a));
            }
        }

    }
}
