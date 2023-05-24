package DataStructure1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P10866 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if(a.equals("push_front")){
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }
            else if(a.equals("push_back")){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            else if(a.equals("pop_front")){
                if(!deque.isEmpty()){
                    sb.append(deque.pollFirst()).append("\n");
                }
                else{
                    sb.append("-1").append("\n");
                }
            }
            else if(a.equals("pop_back")){
                if(!deque.isEmpty()){
                    sb.append(deque.pollLast()).append("\n");
                }
                else{
                    sb.append("-1").append("\n");
                }
            }
            else if(a.equals("size")){
                sb.append(deque.size()).append("\n");
            }
            else if(a.equals("empty")){
                if(deque.isEmpty())
                    sb.append("1\n");
                else sb.append("0\n");
            }
            else if(a.equals("front")){
                if(!deque.isEmpty()){
                    sb.append(deque.peekFirst()).append("\n");
                }
                else{
                    sb.append("-1").append("\n");
                }
            }
            else if(a.equals("back")){
                if(!deque.isEmpty()){
                    sb.append(deque.peekLast()).append("\n");
                }
                else{
                    sb.append("-1").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
