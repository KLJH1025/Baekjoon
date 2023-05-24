package String;

import java.util.Scanner;

public class P06550 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String[] a = scan.nextLine().split(" ");

            char[] origin = a[0].toCharArray();
            char[] compare = a[1].toCharArray();

            int index = 0;
            String answer = "No";
            for(int i=0; i<compare.length; i++){
                if(origin[index] == compare[i]){
                    index += 1;
                }
                if(index == origin.length){
                    answer = "Yes";
                    break;
                }
            }
            System.out.println(answer);

        }
    }
}
