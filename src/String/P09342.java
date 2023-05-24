package String;

import java.util.*;

public class P09342 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0; i<n; i++){
            char[] input = scan.next().toCharArray();
            int index = 0;
            if(input[0] == 'B' || input[0] == 'C' ||
                    input[0] == 'D' || input[0] == 'E' || input[0] == 'F'){
                index = 1;
            }

            String answer = "Good";
            if(input[index] == 'A'){
                while(index < input.length && input[index] == 'A'){
                    index++;
                }
                if(input[index] == 'F'){
                    while(index < input.length && input[index] == 'F'){
                        index++;
                    }
                    if(input[index] == 'C'){
                        while(index < input.length && input[index] == 'C'){
                            index++;
                        }
                        if(index == input.length){
                            answer = "Infected!";
                        }
                        else if(index == input.length-1 &&
                                (input[index] == 'A' || input[index] == 'B' || input[index] == 'C' ||
                                        input[index] == 'D' || input[index] == 'E' || input[index] == 'F')){
                            answer = "Infected!";
                        }
                    }
                }
            }
            System.out.println(answer);

        }
    }


}
