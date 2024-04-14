

public class KnapSack01 {

    //recursion
    public static int knapsack(int val[], int wt[], int W, int idx){
        if(W == 0 || idx == val.length){
            return 0;
        }
        if(wt[idx] <= W){   //valid
            int ans1 = val[idx] + knapsack(val, wt, W-wt[idx], idx+1);
            int ans2 = knapsack(val, wt, W, idx+1);
            return Math.max(ans1,ans2);
        }else{              //invalid
            return knapsack(val, wt, W, idx+1);
        }
    }

    // dp-memoization
    public static int knapsackdp(int val[], int wt[], int W, int n,int dp[][]){
        if(W == 0 || n == 0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(wt[n-1] <= W){   //valid
            int ans1 = val[n-1] + knapsackdp(val, wt, W-wt[n-1], n-1,dp);
            int ans2 = knapsackdp(val, wt, W, n-1,dp);
            return dp[n][W] = Math.max(ans1,ans2);
        }else{              //invalid
            return dp[n][W] = knapsackdp(val, wt, W, n-1,dp);
        }
    }

    public static void print(int dp[][]){
        for(int i=0; i<dp.length;i++){
            for(int j=0;j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print(boolean dp[][]){
        for(int i=0; i<dp.length;i++){
            for(int j=0;j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // dp-Tabulation
    public static int knapsackdptab(int val[], int wt[], int W){
        int n = val.length;
        int dptab[][] = new int[n+1][W+1];
        for(int i=0; i<dptab.length;i++){
            dptab[i][0] = 0;
        }
        for(int j=0;j<dptab[0].length; j++){
            dptab[0][j] = 0;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<W + 1; j++){
                int v = val[i-1];   //ith item value
                int w = wt[i-1];    //ith item wt
                if( w <= j){        // valid
                    int incProfit = v + dptab[i-1][j-w];
                    int excProfit = dptab[i-1][j];
                    dptab[i][j] = Math.max(incProfit, excProfit);
                }else{
                    int excProfit = dptab[i-1][j];
                    dptab[i][j] = excProfit;
                }
            }
        }

        print(dptab);

        return dptab[n][W];
    }

    //TargetSum
    public static boolean targetSum(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        // i = items and j=targetSum;
        for(int i=0; i<n+1;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];
                //include
                if( v <= j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }

        print(dp);

        return dp[n][sum];
    }

    // Unbounded Knapsack -> Tabulation
    public static int unboundedKnapsackTab(int val[], int wt[], int W){
        int n = val.length;
        int dptab[][] = new int[n+1][W+1];
        for(int i=0; i<dptab.length;i++){
            dptab[i][0] = 0;
        }
        for(int j=0;j<dptab[0].length; j++){
            dptab[0][j] = 0;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<W + 1; j++){
                int v = val[i-1];   //ith item value
                int w = wt[i-1];    //ith item wt
                if( w <= j){        // valid
                    int incProfit = v + dptab[i][j-w];
                    int excProfit = dptab[i-1][j];
                    dptab[i][j] = Math.max(incProfit, excProfit);
                }else{
                    int excProfit = dptab[i-1][j];
                    dptab[i][j] = excProfit;
                }
            }
        }
        
        print(dptab);
        return dptab[n][W];
    }

    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = { 2, 5, 1 ,3, 4};

        int W = 7;
        System.out.println(knapsack(val,wt,W,0));

        //Memo
        int dp[][] = new int[val.length+1][W+1];
        for(int i=0; i<dp.length;i++){
            for(int j=1;j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackdp(val, wt, W, val.length, dp));

        //Tabulation
        System.out.println(knapsackdptab(val, wt, W));

        //TargetSum
        int numbers[] = {4,2,7,1,3};
        int sum =10;
        System.out.println(targetSum(numbers,sum));

        //Unbounded Knapsack
        System.out.println(unboundedKnapsackTab(val, wt, W));

    }
}