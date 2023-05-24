package DataStructure2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Date{
    int month;
    int day;
    int hour;
    int minute;

    Date(String date, String time){
        this.month = Integer.parseInt(date.substring(5,7));
        this.day = Integer.parseInt(date.substring(8,10));
        this.hour = Integer.parseInt(time.substring(0,2));
        this.minute = Integer.parseInt(time.substring(3,5));
    }
}

public class P21942 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] monthList = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        int n = Integer.parseInt(st.nextToken());
        String standard = st.nextToken();
        int standard_day = Integer.parseInt(standard.substring(0,3));
        int standard_minute = 60 * Integer.parseInt(standard.substring(4,6)) +
                Integer.parseInt(standard.substring(7,9));
        standard_minute += standard_day * 24 * 60;
        long penalty = Long.parseLong(st.nextToken());

        TreeMap<String, Long> penaltyMap = new TreeMap<>();

        HashMap<String, HashMap<String, Date>> list = new HashMap<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String date = st.nextToken();
            String time = st.nextToken();
            String object = st.nextToken();
            String nickname = st.nextToken();
            Date thisDate = new Date(date, time);

            if(list.containsKey(nickname)){
                HashMap<String, Date> lendRecord = list.get(nickname);
                if(lendRecord.containsKey(object)){
                    //반납
                    Date getDate = lendRecord.get(object);

                    int day_difference = 0;
                    int minute_difference = 0;
                    if(getDate.month == thisDate.month){
                        day_difference = thisDate.day - getDate.day;
                    }
                    else{
                        for(int z=getDate.month; z<thisDate.month; z++){
                            day_difference += monthList[z];
                        }
                        day_difference += thisDate.day;
                        day_difference -= getDate.day;
                    }
                    int pastMinute = getDate.hour * 60 + getDate.minute;
                    int presentMinute = thisDate.hour * 60 + thisDate.minute;
                    minute_difference = day_difference * 24 * 60 + (presentMinute - pastMinute);
                    if(minute_difference <= standard_minute){
                        //벌금없음
                    }
                    else{
                        if(penaltyMap.containsKey(nickname)){
                            long prefixSum = penaltyMap.get(nickname);
                            penaltyMap.put(nickname, prefixSum + (minute_difference - standard_minute) * penalty);
                        }
                        else penaltyMap.put(nickname, (minute_difference - standard_minute) * penalty);
                    }

                    if(lendRecord.size() == 1){
                        lendRecord.clear();
                        list.remove(nickname);
                    }
                    else{
                        lendRecord.remove(object);
                    }


                }
                else{
                    //추가
                    lendRecord.put(object, new Date(date, time));
                }
            }
            else{
                HashMap<String, Date> input = new HashMap<>();
                Date dateInput = new Date(date, time);
                input.put(object, dateInput);
                list.put(nickname, input);
            }

        }

        if(penaltyMap.isEmpty()){
            System.out.println(-1);
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(String s : penaltyMap.keySet()){
                sb.append(s).append(" ").append(penaltyMap.get(s)).append("\n");
            }
            System.out.println(sb);
        }

    }
}
