public class RodCutting {

    public static int rodCutMaxVal(int length[], int price[], int rodLen){
        int n = length.length;
        int dp[][] = new int[n+1][rodLen+1];

        for(int i=1; i<n+1;i++){
            for(int j=1;j<+rodLen+1;j++){
                int p = length[i-1];
                if(p<=j){
                    //include
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-p], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rodLen];
    }

    public static void main(String[] args) {
        
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int rodLen = 8;

        System.out.println(rodCutMaxVal(length,price,rodLen));
    }
}
