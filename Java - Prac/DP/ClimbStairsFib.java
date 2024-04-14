import java.util.Arrays;

public class ClimbStairsFib {

    // recursions -O(2^n)
    public static int ways(int n){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        return ways(n-1) + ways(n-2);
    }

    // dp - memo ->O(n)
    public static int waysdp(int n, int dp[]){
        if( n == 0){
            return 1;
        }
        if( n < 0){
            return 0;
        }
        if( dp[n] != -1){
            return dp[n];
        }
        return dp[n] = waysdp(n-1,dp) + waysdp(n-2, dp);
    }
    //for three steps allowed 1,2,3
    public static int waysdp3(int n, int dp3[]){
        if( n == 0){
            return 1;
        }
        if( n < 0){
            return 0;
        }
        if( dp3[n] != -1){
            return dp3[n];
        }
        return dp3[n] = waysdp3(n-1,dp3) + waysdp3(n-2, dp3) + waysdp3(n-3,dp3);
    }

    //intialization -> O(n)
    public static int waysinit(int n){
        int waysdp[] = new int[n+1];
        
        waysdp[0] = 1;
        for(int i=1;i<=n;i++){
            if( i == 1){
                waysdp[i] = waysdp[ i-1];
            }else{
            waysdp[i] = waysdp[i-1] + waysdp[i-2];
            }
        }
        int ans = waysdp[n];
        return ans;
    }

    public static int waysinit3(int n){
        int waysdp3[] = new int[n+1];
        
        waysdp3[0] = 1;
        for(int i=1;i<=n;i++){
            if( i == 1){
                waysdp3[i] = waysdp3[ i-1];
            }
            else if( i == 2){
                waysdp3[i] = waysdp3[i-1] + waysdp3[i-2];
            }else{
                waysdp3[i] = waysdp3[i-1] + waysdp3[i-2] + waysdp3[i-3];
            }
        }
        int ans = waysdp3[n];
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(ways(n));

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(waysdp(n,dp));

        // 3 steps
        int dp3[] = new int[n+1];
        Arrays.fill(dp3, -1);
        System.out.println(waysdp3(n,dp3));

        //tabulation
        System.out.println(waysinit(n));

        //tabulation -> 3steps
        System.out.println(waysinit3(n));
    }
}
