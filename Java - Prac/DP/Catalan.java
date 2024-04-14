import java.util.Arrays;

public class Catalan {

    //recursion - O(n^2)
    public static int CatlNum(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans += CatlNum(i)*CatlNum(n-i-1);
        }
        return ans;
    }

    //dp-memo
    public static int CatlNumMemo(int n,int dp[]){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans += CatlNumMemo(i,dp)*CatlNumMemo(n-i-1,dp);
        }
        return dp[n] = ans;
    }

    //dp - initiaalize -O(n*n)
    public static int CatlNumTab(int n){
        int dp[] = new int[n+1];

        dp[0] = dp[1] = 1;

        for(int i=2; i<=n; i++){ //Ci
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1]; //Ci = Cj * Ci-j-1
            }
        }

        return dp[n];
    }

    //count no of BST Trees
    public static int countBST(int n){
        int dp[] = new int[n+1];

        dp[0] = dp[1] = 1;

        for(int i=2; i<n+1; i++){ //Ci -> BST ( i nodes) -> dp[i]
            for(int j=0; j<i; j++){
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left * right;
            }
        }

        return dp[n];
    }

    //count no of Mountain ranges
    public static int countMountRanges(int n){
        int dp[] = new int[n+1];

        dp[0] = dp[1] = 1;

        for(int i=2; i<n+1; i++){ //i pairs -> mountain ranges =>Ci
            for(int j=0; j<i; j++){
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside * outside; //Ci = Cj * Ci-j-1;
            }
        }
        //n pairs
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Recursion : " + CatlNum(n));
        int dpm[] = new int[n+1];
        Arrays.fill(dpm, -1);
        System.out.println("Memo : " + CatlNumMemo(n,dpm));

        System.out.println("----");

        // n = 30;
        // int d[] = new int[n+1];
        // Arrays.fill(d, -1);
        // System.out.println(CatlNumMemo(n,d));
        // System.out.println(CatlNum(n));

        //Iniatialization - Tab
        System.out.println("Tabulation : " + CatlNumTab(n));

        //No of nodes
        int arr[] = {10,20,30,40};
        System.out.println("No of nodes : " + countBST(arr.length));

        // Mountain Ranges
        System.out.println("MR : " + countMountRanges(4));
    }
}
