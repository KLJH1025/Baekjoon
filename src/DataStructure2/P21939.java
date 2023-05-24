package DataStructure2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P21939 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int problem_number = Integer.parseInt(st.nextToken());
            int problem_level = Integer.parseInt(st.nextToken());
            if(map.containsKey(problem_level)){
                TreeSet<Integer> treeSet = map.get(problem_level);
                treeSet.add(problem_number);
                map.put(problem_level, treeSet);
            }
            else {
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(problem_number);
                map.put(problem_level, treeSet);
            }
        }

        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")){
                int PNum = Integer.parseInt(st.nextToken());
                int PLevel = Integer.parseInt(st.nextToken());
                if(map.containsKey(PLevel)){
                    TreeSet<Integer> temp = map.get(PLevel);
                    temp.add(PNum);
                    map.put(PLevel, temp);
                }
                else{
                    TreeSet<Integer> temp = new TreeSet<>();
                    temp.add(PNum);
                    map.put(PLevel, temp);
                }
            }
            else if(command.equals("solved")){
                int temp = Integer.parseInt(st.nextToken());
                int checkNum = -1;
                for(int num : map.keySet()){
                    if(map.get(num).contains(temp)){
                        checkNum = num;
                        break;
                    }
                }
                if(checkNum != -1){
                    if(map.get(checkNum).size() != 1)
                        map.get(checkNum).remove(temp);
                    else map.remove(checkNum);
                }
            }
            else if(command.equals("recommend")){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    sb.append(map.get(map.lastKey()).last()).append("\n");
                }
                else if(temp == -1){
                    sb.append(map.get(map.firstKey()).first()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
