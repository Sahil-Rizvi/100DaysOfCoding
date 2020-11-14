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
            return editDistance(str1,str2, m-1, n-1);
        }
        return 1+Math.min(editDistance(str1,str2, m-1, n-1),
                Math.min(editDistance(str1, str2, m-1,n),
                        editDistance(str1, str2, m, n-1)) );
    }

    @Test
    public void test(){
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(editDistance(str1,str2,str1.length(),str2.length()));
    }

}
