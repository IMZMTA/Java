import java.util.*;

public class LCS {

    //recursion ->O(2^n)
    public static int longestCommonSubseq(String s1, String s2, int n, int m){
        if( n == 0 | m == 0){
            return 0;
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){ //same
            return longestCommonSubseq(s1, s2, n-1, m-1) + 1;
        }else{                                //different
            return Math.max(longestCommonSubseq(s1, s2, n, m-1),longestCommonSubseq(s1, s2, n-1, m));
        }
    }

    //memo
    public static int lCSubseqmemo(String s1, String s2, int n, int m, int dp[][]){
        if( n == 0 | m == 0){
            return 0;
        }
        if( dp[n][m] != -1 ){
            return dp[n][m];
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){ //same
            return dp[n][m] = longestCommonSubseq(s1, s2, n-1, m-1) + 1;
        }else{                                //different
            return dp[n][m] = Math.max(longestCommonSubseq(s1, s2, n, m-1),longestCommonSubseq(s1, s2, n-1, m));
        }
    }

    //tabulation ->O(n*m)
    public static int lCSubseqinit(String s1, String s2, int n, int m){
        
        int dpt[][] = new int[n+1][m+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dpt[i][j] = dpt[i-1][j-1] + 1;
                }else{
                    dpt[i][j] = Math.max(dpt[i-1][j], dpt[i][j-1]);
                }
            }
        }
        return dpt[n][m];
    }

    public static int lCSubs(String s1, String s2){ //O(n*m)
        int n = s1.length();
        int m = s2.length();
        int ans = 0;

        int dp[][] = new int[n+1][m+1];

        for(int i=1; i<n+1;i++){
            for(int j=1; j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static int lcs(int arr1[], int arr2[]){ //O(n*m)
        int n = arr1.length;
        int m = arr2.length;
        int ans = 0;

        int dp[][] = new int[n+1][m+1];

        for(int i=1; i<n+1;i++){
            for(int j=1; j<m+1;j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static int lIS(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }

        int arr2[] = new int[set.size()]; //Sorted unique els
        int i=0;
        for(int num : set){
            arr2[i++] = num;
        }
        Arrays.sort(arr2); //Ascending

        return lcs(arr,arr2);
    }

    //print    
    public static void print(int dp[][]){
        for(int i=0; i<dp.length;i++){
            for(int j=0;j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //edit Dist
    public static int editDist(String w1, String w2){
        int n = w1.length();
        int m = w2.length();

        int dpe[][] = new int[n+1][m+1];
        
        for(int i=0; i<n+1; i++){
            dpe[i][0] = i;
        }

        for(int j=0; j<m+1; j++){
            dpe[0][j] = j;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(w1.charAt(i-1)==w2.charAt(j-1)){
                    dpe[i][j] = dpe[i-1][j-1];
                }else{
                    int addans = dpe[i][j-1] ;
                    int delans = dpe[i-1][j] ;
                    int repans = dpe[i-1][j-1] ;
                    dpe[i][j] = Math.min(addans,Math.min(delans,repans)) + 1;
                }
            }
        }
        print(dpe);
        return dpe[n][m];
    }
    
    //str conversion with del and insert
    public static int strconLCS(String w1, String w2){
        int n = w1.length();
        int m = w2.length();
        int len = lCSubseqinit(w1, w2,n,m);

        System.out.println("w1->" + w1 + " w2->" + w2 + " l->" + len + " n->" + n + " m->" + m);

        return (n - len) + (m - len);
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        //recursion
        System.out.println(longestCommonSubseq(s1,s2,s1.length(),s2.length()));
        //dp - memo
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(lCSubseqmemo(s1,s2,n,m,dp));
        //tabulation
        System.out.println(lCSubseqinit(s1, s2, n, m));


        //Longest Common Substring
        System.out.println("Substr : " + lCSubs("ABCDE","ABGCE"));


        //Longest Increasing Subsequence
        int arr[] = { 50, 3, 10, 7, 40, 80};
        System.out.println(lIS(arr));


        //Edit Distance
        String w1 = "intention";
        String w2 = "execution";
        System.out.println("Edit dist : " + editDist(w1, w2));
        System.out.println("Edit dist : " + editDist("abc", "sbd"));


        //String Conversion with delete and insert only
        System.out.println(strconLCS("abcdef","aceg"));
    }
}