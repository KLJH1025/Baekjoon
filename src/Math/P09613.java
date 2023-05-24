package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P09613 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;
            int k = Integer.parseInt(st.nextToken());
            int[] list = new int[k];
            for(int j=0; j<k; j++){
                list[j] = Integer.parseInt(st.nextToken());
            }

            for(int x=0; x<k; x++){
                for(int y=x+1; y<k; y++){
                    sum += Euclid(list[x],list[y]);
                }
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    public static int Euclid(int a, int b){
        int A = a;
        int B = b;
        if(a < b){
            A = b;
            B = a;
        }
        while(true){
            int temp = A % B;
            if(temp == 0){
                break;
            }
            else{
                A = B;
                B = temp;
            }
        }

        return B;
    }
}
