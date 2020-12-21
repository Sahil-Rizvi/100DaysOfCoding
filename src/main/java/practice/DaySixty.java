package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class DaySixty {

    public static boolean isBalanced(String str){
        var stack = new Stack<>();
        var mappings = new HashMap<Character, Character>();
        mappings.put(')','(');
        mappings.put('}','{');
        mappings.put(']','[');
        var i = 0;
        while(i < str.length()){
            var currentCharacter = str.charAt(i);
            if(currentCharacter == '[' || currentCharacter =='{' || currentCharacter == '('){
                stack.push(currentCharacter);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.pop()!=mappings.get(currentCharacter)){
                    return false;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }

    public static boolean isBalancedUsingRecursion(String str, int index, String prevCharacters){
        if(str==null || str.isEmpty()){
            return true;
        }
        if(index == str.length()){
            return prevCharacters.isEmpty();
        }

        var mappings = new HashMap<Character, Character>();
        mappings.put(')','(');
        mappings.put('}','{');
        mappings.put(']','[');

        var character = str.charAt(index) ;
        if(character == '[' || character == '{' || character == '('){
            return isBalancedUsingRecursion(str, index+1, prevCharacters+character);
        } else{
            if(prevCharacters == null || prevCharacters.isEmpty()){
                return false;
            }
            if(prevCharacters.charAt(prevCharacters.length()-1) != mappings.get(character)){
                return false;
            }
            prevCharacters = prevCharacters.substring(0, prevCharacters.length()-1);
            return isBalancedUsingRecursion(str, index+1, prevCharacters);
        }
    }


    @Test
    public void test(){
        Assert.assertTrue(isBalanced("()({})"));
        Assert.assertFalse(isBalanced("([)]"));
        Assert.assertFalse(isBalanced("((()"));
        Assert.assertTrue(isBalanced("([{}])"));
        Assert.assertTrue(isBalanced("[()]{}{[()()]()}"));
        Assert.assertFalse(isBalanced("[(])"));

        Assert.assertTrue(isBalancedUsingRecursion("()({})",0,""));
        Assert.assertFalse(isBalancedUsingRecursion("([)]",0,""));
        Assert.assertFalse(isBalancedUsingRecursion("((()",0,""));
        Assert.assertTrue(isBalancedUsingRecursion("([{}])",0,""));
        Assert.assertTrue(isBalancedUsingRecursion("[()]{}{[()()]()}",0,""));
        Assert.assertFalse(isBalancedUsingRecursion("[(])",0,""));

    }
}
