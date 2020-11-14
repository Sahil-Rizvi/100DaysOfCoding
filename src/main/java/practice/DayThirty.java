package practice;

import org.junit.Test;

public class DayThirty {

    public static int editDistance(String str1, String str2, int m, int n){
        if(m==0){
            return n;
        }
        if(n==0){
            return m;
        }
        if(str1.charAt(m-1) == str2.charAt(n-1)){
            return editDistance(str1, str2, m-1,n-1);
        }
        return 1 + Math.min(
                editDistance(str1,str2,m-1,n-1),
                Math.min(
                        editDistance(str1, str2, m, n-1),
                        editDistance(str1, str2, m-1, n)
                )
        );
    }

    public static int editDistanceDP(String str1, String str2, int m, int n){
        var ed = new int[m+1][n+1];

        // when second string is empty
        for(int i=0;i<m;i++){
            ed[i][0] = i;
        }

        for(var i=0;i<=m;i++){
            for(var j=1;j<=n;j++){
                if(i==0){
                    ed[i][j] = j;
                } else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    ed[i][j] = ed[i-1][j-1];
                } else{
                    ed[i][j] = 1 + Math.min(
                                            ed[i-1][j-1],
                                            Math.min(
                                                    ed[i][j-1],
                                                    ed[i-1][j]
                                            )
                                           );
                }
            }
        }

        return ed[m][n];
    }

    // time complexity is O(m*n)
    // space complexity is O(min(m,n))
    public static int editDistanceDPOptimized(String str1, String str2, int m, int n){
        var minLength = Math.min(m,n);
        var maxLength = Math.max(m,n);

        var dp = new int[2][minLength+1];
        // case when second string is empty
        // delete all characters of first string
        for(var i=0;i<=minLength;i++){
            dp[0][i] = i;
        }

        for(var i=1;i<=str2.length();i++){
            for(var j=0;j<=str1.length();j++){
                if(j==0){ // case when first string is empty
                    // insert all characters of second string
                    dp[i%2][j] = i;
                } else if(str2.charAt(i-1)==str1.charAt(j-1)){
                    dp[i%2][j] = dp[(i-1)%2][j-1];
                } else{
                    dp[i%2][j] = 1 + Math.min(
                            dp[(i-1)%2][j-1], // replacement
                            Math.min(
                                    dp[(i-1)%2][j], // insertion
                                    dp[i%2][j-1] // deletion
                            )
                    );
                }
            }
        }
        return dp[maxLength%2][m];
    }



    @Test
    public void test(){
        String str1 = "kitten";
        String str2 = "sitting";
        System.out.println(editDistance(str1,str2,str1.length(),str2.length()));
        System.out.println(editDistanceDP(str1,str2,str1.length(),str2.length()));
        System.out.println(editDistanceDPOptimized(str1,str2,str1.length(),str2.length()));
    }

}
