package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11728 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] list1 = new long[n];
        long[] list2 = new long[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list1[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            list2[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(list1);
        Arrays.sort(list2);

        StringBuilder sb = new StringBuilder();
        int list1_pointer = 0;
        int list2_pointer = 0;

        while(true){
            if(list1_pointer == n){
                for(int i=list2_pointer; i<m; i++){
                    sb.append(list2[i]).append(" ");
                }
                break;
            }
            else if(list2_pointer == m){
                for(int i=list1_pointer; i<n; i++){
                    sb.append(list1[i]).append(" ");
                }
                break;
            }
            else{
                if(list1[list1_pointer] > list2[list2_pointer]){
                    sb.append(list2[list2_pointer++]).append(" ");
                }
                else{
                    sb.append(list1[list1_pointer++]).append(" ");
                }
            }
        }
        System.out.println(sb);

    }
}
