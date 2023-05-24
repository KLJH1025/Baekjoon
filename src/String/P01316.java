package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P01316 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=0; i<n; i++){
            char[] input = br.readLine().toCharArray();
            HashSet<Character> hashSet = new HashSet<>();
            boolean flag = true;
            for(int j=0; j<input.length; j++){
                if(!hashSet.contains(input[j])){
                    hashSet.add(input[j]);
                    for(int k=j+1; k<input.length; k++){
                        if(input[j] != input[k]){
                            j = k-1;
                            break;
                        }
                    }
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        System.out.println(answer);
    }
}
