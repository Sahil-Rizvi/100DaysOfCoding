package practice;

import org.junit.Test;

public class DayTwentySix {


    public static boolean isBalanced(String str, int index, int count){
        if(index==str.length()){
            return 0==count;
        }
        if(count<0){
            return false;
        }
        if(str.charAt(index) == '('){
            return isBalanced(str, index+1, count+1);
        }
        return isBalanced(str,index+1,count-1);
    }

    public static boolean isBalancedWithStar(String str, int index, int count){
        if(index==str.length()){
            return 0==count;
        }
        if(count<0){
            return false;
        }
        if(str.charAt(index) == '('){
            return isBalancedWithStar(str, index+1, count+1);
        }
        if(str.charAt(index) == '*'){
            // 1. when * is space
            // 2. when * is )
            // 3. when * is (
            return isBalancedWithStar(str, index+1, count)
                    || isBalancedWithStar(str, index+1, count-1)
                    || isBalancedWithStar(str, index+1, count+1);
        }
        return isBalancedWithStar(str,index+1,count-1);
    }


    public static boolean isBalancedWithStarOptimized(String str){
        var low = 0;
        var high = 0;

        for(var i=0;i<str.length();i++){
            if(str.charAt(i) == '('){
                low+=1;
                high+=1;
            } else if(str.charAt(i) == ')'){
                low = Math.max(low-1,0);
                high+=-1;
            }
            else{
                // case when str.charAt(i) == '*'

                // where low is minimum no. of unbalanced open parentheses
                // considering case when '*' is ')', so decrement low
                low = Math.max(low-1,0);

                // where high is maximum no. of unbalanced open parentheses, considering
                // considering case when '*' is '(', so increment high
                high+=1;
            }
            if(high<0){
                return false;
            }
        }
        return 0==low;
    }


    public static boolean isBalancedParentheses(String str, int index, int count, String prevChars){
        if(index==str.length()){
            return 0==count;
        }
        if(count<0){
            return false;
        }

        if(str.charAt(index) == '(' || str.charAt(index) == '[' || str.charAt(index) == '{'){
            return isBalancedParentheses(str, index+1, count+1,prevChars+str.charAt(index));
        }

        if((!prevChars.isEmpty()) && (str.charAt(index) == ')' && prevChars.charAt(prevChars.length()-1) == '('
                || str.charAt(index) == ']' && prevChars.charAt(prevChars.length()-1) == '['
                || str.charAt(index) == '}' && prevChars.charAt(prevChars.length()-1) == '{')){
            return isBalancedParentheses(str, index+1, count-1,prevChars.substring(0,prevChars.length()-1));
        }
        return false;
    }

//    public static boolean isBalanced(String str, int index, int count){
//        if(index == str.length())
//            return count==0;
//        if(count<0){
//            return false;
//        }
//        if(str.charAt(index) == '('){
//            return isBalanced(str,index+1,count+1);
//        }
//
//        return isBalanced(str,index+1,count-1);
//
//    }
//
//    public static boolean isBalancedWithStar(String str, int index, int count){
//        if(index == str.length())
//            return count==0;
//        if(count<0){
//            return false;
//        }
//        if(str.charAt(index) == '('){
//            return isBalancedWithStar(str,index+1,count+1);
//        }
//
//        if(str.charAt(index) == '*'){
//            return isBalancedWithStar(str, index+1,count+1)
//                    || isBalancedWithStar(str, index+1,count-1)
//                    || isBalancedWithStar(str, index+1,count);
//        }
//
//        return isBalancedWithStar(str,index+1,count-1);
//
//    }
//
//    public static boolean areParenthesesBalanced(String str,int index, int count, String prevChars){
//        if(index==str.length()){
//            return count == 0 && prevChars.length() == 0;
//        }
//        if(str.charAt(index) == '(' || str.charAt(index) == '{' || str.charAt(index) == '[')
//            return areParenthesesBalanced(str, index+1, count+1, prevChars + str.charAt(index));
//
//        if( (str.charAt(index) == ')' && prevChars.charAt(prevChars.length()-1) == '(')
//                || (str.charAt(index) == '}' && prevChars.charAt(prevChars.length()-1) == '{')
//                || (str.charAt(index) == ']' && prevChars.charAt(prevChars.length()-1) == '[') )
//            return areParenthesesBalanced(str, index+1, count-1, prevChars.substring(0, prevChars.length()-1));
//        return false;
//    }


    @Test
    public void test(){
        //System.out.println(areParenthesesBalanced("[(])",0,0,""));
        //System.out.println(isBalanced("())((())",0,0));
        //System.out.println(isBalanced(")(",0,0));
        //System.out.println(isBalancedParentheses("{()}[]",0,0,""));
        //System.out.println(isBalancedWithStar(")*(",0,0));
        System.out.println(isBalancedWithStarOptimized(")*("));

    }
}
