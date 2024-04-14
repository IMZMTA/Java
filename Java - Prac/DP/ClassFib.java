public class ClassFib{
    public static int fib(int n){   //O(n^e)
        if( n==0 || n==1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static int fibdp(int n, int f[]){   //O(n)

        if( n==0 || n==1){
            return n;
        }
        if(f[n] != 0){  //f[n] is already calculated;
            return f[n];
        }
        return f[n] = fibdp(n-1,f) + fibdp(n-2,f);
    }

    public static int fibint(int n){
        int dp[] = new int[n+1];
        dp[1] = 1;

        for(int i=2; i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        
        //Memoization
        int n = 8;
        System.out.println(fib(n));

        int f[] = new int[n+1];
        System.out.println(fibdp(n, f));

        //Tabulation
        //Initialization -> Meaning -> Filling
        System.out.println(fibint(n));
    }
}