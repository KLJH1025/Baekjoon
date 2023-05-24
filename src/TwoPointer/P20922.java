package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P20922 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int answer = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(end = 0; end<n; end++){
            if(hashMap.containsKey(list[end])){
                if(hashMap.get(list[end]) == m){
                    //
                    while(list[start] != list[end]){
                        if(hashMap.get(list[start]) == 1){
                            hashMap.remove(list[start]);
                        }
                        else{
                            hashMap.put(list[start], hashMap.get(list[start])-1);
                        }
                        start += 1;
                    }
                    start += 1;
                }
                else{
                    hashMap.put(list[end], hashMap.get(list[end])+1);
                }
            }
            else{
                hashMap.put(list[end], 1);
            }
            answer = Math.max(answer, end-start+1);
        }
        System.out.println(answer);
    }
}
