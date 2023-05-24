package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P22943 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int MAX = 100000;
        int[] choice = {1,10,100,1000,10000,100000};

        // 소수 판별 배열. 소수면 false, 소수아니면 true
        boolean[] primes = new boolean[100000];
        primes[0] = true;
        primes[1] = true;
        for(int i=2; i<100000; i++){
            for(int j=i*2; j<100000; j+=i){
                primes[j] = true;
            }
        }

        // 각 숫자가 중복되지 않는 숫자로 이루어진 조합이면 true.
        boolean[] base = new boolean[MAX];
        for(int i=1; i<MAX; i++){
            if(check(i))
                base[i] = true;
        }

        // 소수 2개의 합으로 나타낼 수 있는 경우 true
        boolean[] condition1 = new boolean[MAX];
        for(int i=2; i<MAX; i++){
            if(primes[i])
                continue;
            for(int j=i+1; j<MAX; j++){
                if(primes[j])
                    continue;
                if(i+j <MAX)
                    condition1[i+j] = true;
            }
        }

        // 소수 2개의 곱으로 이루어진 경우 true
        boolean[] condition2 = new boolean[MAX];
        for(int i=2; i<MAX; i++){
            if(primes[i])
                continue;
            for(int j=i; j<MAX; j++){
                if(primes[j])
                    continue;
                long temp = (long)i*(long)j;
                if(temp < MAX)
                    condition2[i*j] = true;
            }
        }

        int answer = 0;

        for(int i=choice[k-1]; i<choice[k]; i++){
            int temp = i;
            while(temp%m == 0){
                temp /= m;
            }
            if(base[i] && condition1[i] && condition2[temp])
                answer += 1;
        }

        System.out.println(answer);

    }

    public static boolean check(int n){
        String temp = String.valueOf(n);
        boolean[] check = new boolean[10];
        for(int i=0; i<temp.length(); i++){
            if(check[temp.charAt(i)-'0'])
                return false;
            else
                check[temp.charAt(i)-'0'] = true;
        }
        return true;
    }

}
