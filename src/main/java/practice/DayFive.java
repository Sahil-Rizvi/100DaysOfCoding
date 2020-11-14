package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DayFive {

    private static class Key{
        char data;
        int freq;

        public Key(char data, int freq) {
            this.data = data;
            this.freq = freq;
        }
    }
    public static String stringWithNonRepeatingCharacters(String str){
        final int MAX_CHARACTERS = 256;
        var freq = new int[MAX_CHARACTERS];
        var queue = new PriorityQueue<Key>(5, (a,b) -> {
            if(b.freq == a.freq)
                return a.data - b.data;
            return b.freq - a.freq;
        });
        Arrays.fill(freq,0);
        // counting frequency of each character in string
        for(var i=0;i<str.length();i++){
            freq[str.charAt(i)-'a']++;
        }

        for(var i=0;i<MAX_CHARACTERS;i++){
            if(freq[i] > 0){
                queue.add(new Key((char)(i+'a'),freq[i]));
            }
        }

        var prevKey = new Key('#',-1);

        StringBuilder stringBuilder = new StringBuilder();
        while(!queue.isEmpty()){
            var top = queue.poll();
            stringBuilder.append(top.data);
            if(prevKey.freq>0){
                queue.add(prevKey);
            }
            prevKey = top;
            prevKey.freq--;
        }
        String res = stringBuilder.toString();
        if(res.length()==str.length()){
            return res;
        }
        return null;
    }

    @Test
    public void testStringWithNonRepeatingCharacters(){
        Assert.assertEquals("ababac",stringWithNonRepeatingCharacters("aaabbc"));
        Assert.assertEquals("babab",stringWithNonRepeatingCharacters("bbbaa"));
        Assert.assertNull(stringWithNonRepeatingCharacters("aa"));
        Assert.assertNull(stringWithNonRepeatingCharacters("aaaabc"));
    }
}
