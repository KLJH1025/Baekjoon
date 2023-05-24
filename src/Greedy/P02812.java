package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P02812 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[] s = br.readLine().toCharArray();

        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<s.length; i++){
            if(deque.isEmpty()){
                deque.addLast(s[i] - '0');
            }else{
                while(m>0 && !deque.isEmpty() && deque.peekLast() < s[i]-'0'){
                    deque.pollLast();
                    m--;
                }
                deque.add(s[i] - '0');
            }
        }

        StringBuilder ans = new StringBuilder();

        while (deque.size() > m) {
            ans.append(deque.removeFirst());
        }

        System.out.println(ans);

    }
}
