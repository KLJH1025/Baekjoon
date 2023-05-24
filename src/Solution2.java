import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            int down = Integer.parseInt(st.nextToken());
            int up = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();

            int lastUpIndex = -1;

            for(int j=0; j<input.length(); j++){
                int getOne = input.charAt(j) - '0';
                if(getOne > up){
                    sb.append(up);
                    // 손해 발생 -> 끝남
                    for(int k=j+1; k<input.length(); k++){
                        sb.append(up);
                    }
                    break;
                }
                else if(getOne == up){
                    sb.append(up);
                    lastUpIndex = j;
                }
                else if(getOne < up && getOne > down){
                    if(!(down == 0 && sb.length() == 0)) {
                        sb.append(down);
                        // 손해 발생  -> 끝남
                        for (int k = j + 1; k < input.length(); k++) {
                            sb.append(up);
                        }
                        break;
                    }
                    else if(down == 0){
                        for (int k = j + 1; k < input.length(); k++) {
                            sb.append(up);
                        }
                        break;
                    }
                }
                else if(getOne == down){
                    sb.append(down);
                }
                else if(getOne < down){
                    if(j == 0){
                        sb = new StringBuilder();
                        for(int k=0; k<input.length()-1; k++){
                            sb.append(up);
                        }
                        break;
                    }
                    else if(lastUpIndex == -1){
                        sb = new StringBuilder();
                        for(int k=0; k<input.length()-1; k++){
                            sb.append(up);
                        }
                        break;
                    }
                    else{
                        String original = new String(sb);
                        sb = new StringBuilder();
                        for(int k=0; k<lastUpIndex; k++){
                            sb.append(original.charAt(k));
                        }
                        sb.append(down);
                        for(int k=lastUpIndex+1; k<input.length(); k++){
                            sb.append(up);
                        }
                        break;
                    }
                }
            }
            if(sb.length() == 0 || sb.toString().equals("0"))
                System.out.println("#" + i + " -1");
            else System.out.println("#" + i + " " + sb);
        }
    }
}
