public class WildMatch {
    public static boolean wildCardMatch(String s, String p){ //O(n*m)->Hard
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        //init
        dp[0][0] = true;
        for(int i=1;i<n+1;i++){     //pattern = " ";
            dp[i][0] = false;
        }
        for(int j=1;j<m+1;j++){
            if( p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            } 
        }

        //bottom up
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                //case 1 -> ith char == jth char || jthchar == ?
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "baaabab";
        String p = "*****ba*****ab";
        System.out.println(wildCardMatch(s, p));;
        System.out.println(wildCardMatch("abcd", "aa?c"));;
    }
}
