package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P01092 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> machine = new ArrayList<>();
        for(int i=0; i<n; i++){
            machine.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0 ;i<m; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(machine, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        //
        int count = 0;
        int machine_point = 0;

        if(machine.get(machine_point) < box.get(0)){
            System.out.println(-1);
            return;
        }

        /*
        while(true){
            if(machine.get(machine_point) >= box.get(0)) {
                machine_point += 1;
                if(machine_point == machine.size()){
                    count += 1;
                    machine_point = 0;
                }
                box.remove(0);
                if(box.size() == 0){
                    count += 1;
                    break;
                }
            }
            else if(machine.get(machine_point) < box.get(0)){
                count += 1;
                machine_point = 0;
            }
        }*/

        while(!box.isEmpty()){
            int boxIndex = 0;
            int machineIndex = 0;
            while(machineIndex < n){
                if(boxIndex == box.size())
                    break;
                else if(machine.get(machineIndex) >= box.get(boxIndex)){
                    box.remove(boxIndex);
                    machineIndex++;
                }
                else{
                    boxIndex++;
                }
            }
            count++;
        }

        System.out.println(count);
        //

    }
}
