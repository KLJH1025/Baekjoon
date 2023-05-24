package DataStructure1;

import java.util.*;
import java.io.*;

class Circle implements Comparable<Circle>{
    int left;
    int right;
    Circle(int left, int right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Circle o){
        if(this.left == o.left){
            return this.right - o.right;
        }
        return this.left - o.left;
    }
}

class P22942{

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Circle> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            arrayList.add(new Circle(x - r, x + r));
        }
        Collections.sort(arrayList);

        for(int i=0; i<n-1; i++){
            Circle c1 = arrayList.get(i);
            Circle c2 = arrayList.get(i+1);

            if(c1.left == c2.left || c1.right == c2.right || c1.right == c2.left){
                System.out.println("NO");
                return;
            }
            if(c1.right > c2.left && c1.right < c2.right){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}