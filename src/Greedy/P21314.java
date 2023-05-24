package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P21314 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        //M K K M M K
        int countM = 0;
        for(int i=0; i< input.length; i++){
            if(input[i] == 'M'){
                countM++;
            }
            else if(input[i] == 'K'){
                if(countM > 0){
                    sb.append(5);
                    for(int j=0; j<countM; j++){
                        sb.append(0);
                    }
                    countM = 0;
                }
                else if(countM == 0){
                    sb.append(5);
                }
            }
        }
        if(countM > 0){
            for(int i=0; i<countM; i++){
                sb.append(1);
            }
        }

        sb.append("\n");

        //M K K M M K
        countM = 0;
        for(int i=0; i<input.length; i++){
            if(input[i] == 'M'){
                countM++;
            }
            else if(input[i] == 'K'){
                if(countM > 0){
                    sb.append(1);
                    for(int j=1; j<countM; j++){
                        sb.append(0);
                    }
                    sb.append(5);
                    countM = 0;
                }
                else if(countM == 0){
                    sb.append(5);
                }
            }
        }
        if(countM > 0){
            sb.append(1);
            for(int i=1; i<countM; i++){
                sb.append(0);
            }
        }

        System.out.println(sb);

    }
}
