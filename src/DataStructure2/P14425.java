package DataStructure2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P14425 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();
        for(int i=0; i<n; i++){
            hashSet.add(br.readLine());
        }

        int count = 0;
        for(int i=0; i<m; i++){
            String a = br.readLine();
            if(hashSet.contains(a))
                count++;
        }
        System.out.println(count);

    }
}
