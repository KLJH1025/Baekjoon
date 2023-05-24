package DataStructure2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Problem implements Comparable<Problem>{
    int number;
    int level;
    int sort;

    public Problem(int number, int level, int sort){
        this.number = number;
        this.level = level;
        this.sort = sort;
    }

    @Override
    public int compareTo(Problem o1){
        if(this.level == o1.level){
            return this.number - o1.number;
        }
        return this.level - o1.level;
    }
}

public class P21944 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        TreeSet<Problem> treeSet = new TreeSet<>();
        HashMap<Integer, TreeSet<Problem>> hashMap = new HashMap<>();
        HashMap<Integer, Integer> numberToLevel = new HashMap<>();
        HashMap<Integer, Integer> numberToSort = new HashMap<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int problem_number = Integer.parseInt(st.nextToken());
            int problem_level = Integer.parseInt(st.nextToken());
            int problem_sort = Integer.parseInt(st.nextToken());

            //===================================================//
            treeSet.add(new Problem(problem_number, problem_level, problem_sort));
            numberToLevel.put(problem_number, problem_level);
            numberToSort.put(problem_number, problem_sort);
            if(hashMap.containsKey(problem_sort)){
                TreeSet temp = hashMap.get(problem_sort);
                temp.add(new Problem(problem_number, problem_level, problem_sort));
                hashMap.put(problem_sort, temp);
            }
            else{
                TreeSet temp = new TreeSet();
                temp.add(new Problem(problem_number, problem_level, problem_sort));
                hashMap.put(problem_sort, temp);
            }
            //===================================================//
        }

        ////

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("recommend")){
                int sort_number = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                TreeSet<Problem> problemTreeSet = hashMap.get(sort_number);
                if(x == 1){
                    sb.append(problemTreeSet.last().number).append("\n");
                }
                else if(x == -1){
                    sb.append(problemTreeSet.first().number).append("\n");
                }
            }
            else if(command.equals("recommend2")){
                int x = Integer.parseInt(st.nextToken());
                if(x == 1){
                    sb.append(treeSet.last().number).append("\n");
                }
                else if(x == -1){
                    sb.append(treeSet.first().number).append("\n");
                }
            }
            else if(command.equals("recommend3")){
                int x = Integer.parseInt(st.nextToken());
                int standard = Integer.parseInt(st.nextToken());

                if(x == 1){
                    if(treeSet.ceiling(new Problem(0, standard, 0)) != null){
                        sb.append(treeSet.ceiling(new Problem(0, standard, 0)).number).append("\n");
                    }
                    else{
                        sb.append("-1\n");
                    }
                }
                else if(x == -1){
                    if(treeSet.floor(new Problem(0, standard, 0)) != null){
                        sb.append(treeSet.floor(new Problem(0, standard, 0)).number).append("\n");
                    }
                    else{
                        sb.append("-1\n");
                    }
                }


            }
            else if(command.equals("add")){
                int add_number = Integer.parseInt(st.nextToken());
                int add_level = Integer.parseInt(st.nextToken());
                int add_sort = Integer.parseInt(st.nextToken());

                //
                treeSet.add(new Problem(add_number, add_level, add_sort));
                numberToLevel.put(add_number, add_level);
                numberToSort.put(add_number, add_sort);

                if(hashMap.containsKey(add_sort)){
                    TreeSet temp = hashMap.get(add_sort);
                    temp.add(new Problem(add_number, add_level, add_sort));
                    hashMap.put(add_sort, temp);
                }
                else{
                    TreeSet temp = new TreeSet();
                    temp.add(new Problem(add_number, add_level, add_sort));
                    hashMap.put(add_sort, temp);
                }
                //

            }
            else if(command.equals("solved")){
                int remove_number = Integer.parseInt(st.nextToken());

                int n_idx = remove_number;
                int n_level = numberToLevel.get(remove_number);
                int n_algo = numberToSort.get(remove_number);
                treeSet.remove(new Problem(n_idx, n_level, n_algo));
                hashMap.get(n_algo).remove(new Problem(n_idx, n_level, n_algo));
                numberToLevel.remove(n_idx);
                numberToSort.remove(n_idx);
            }
        }

        System.out.println(sb);
    }
}
