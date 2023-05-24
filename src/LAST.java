import java.io.*;
import java.util.*;

public class LAST {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        String compare = br.readLine();

        int answer = KMP(origin, compare);
        System.out.print(answer);
    }

    public static int KMP(String origin, String compare) {
        int[] pi = getPi(compare);

        int j = 0;
        for(int i = 0; i < origin.length(); i++) {
            while(j > 0 && origin.charAt(i) != compare.charAt(j)) {
                j = pi[j - 1];
            }
            if(origin.charAt(i) == compare.charAt(j)) {
                if(j == compare.length() - 1) {
                    return 1;
                }
                else {
                    j++;
                }
            }
        }
        return 0;
    }

    public static int[] getPi(String compare) {
        int[] pi = new int[compare.length()];
        int j = 0;
        for(int i = 1; i < compare.length(); i++) {
            while(j > 0 && compare.charAt(i) != compare.charAt(j)) {
                j = pi[j - 1];
            }
            if(compare.charAt(i) == compare.charAt(j)) {
                j += 1;
                pi[i] = j;
            }
        }
        return pi;
    }

}