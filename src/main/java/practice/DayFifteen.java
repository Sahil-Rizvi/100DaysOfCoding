package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayFifteen {

    private static class TrieNode{
        Character character;
        HashMap<Character,TrieNode> children;
        boolean isEndOfWord;
        int frequency;

        TrieNode(){
            this.frequency = 0;
            this.isEndOfWord = false;
            this.children = new HashMap<>();
        }
        TrieNode(Character c){
            this(c,1);
        }

        TrieNode(Character c,int frequency){
            this.character = c;
            this.frequency = frequency;
            this.children = new HashMap<>();
        }
    }

    private static class Trie{

        TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        public void insert(String s){
            TrieNode temp = root;
            for(var i=0;i<s.length();i++){
                Character c = s.charAt(i);
                TrieNode child = temp.children.get(c);
                if(child == null){
                    child = new TrieNode(c);
                }
                else{
                    child.frequency++;
                }
                temp.children.put(c, child);
                temp = child;
            }
            temp.isEndOfWord = true;
        }

        public void insert(String s,int i, TrieNode root){
            if(i==s.length()){
                root.isEndOfWord = true;
                return;
            }
            TrieNode temp = root.children.get(s.charAt(i));
            if(temp==null){
                temp = new TrieNode(s.charAt(i));
                root.children.put(s.charAt(i), temp);
            }
            insert(s,i+1,temp);
        }

        public boolean search(String s,int i,TrieNode root){
            if(i==s.length()){
                return root.isEndOfWord;
            }
            var temp = root.children.get(s.charAt(i));
            if(temp==null){
                return false;
            }
            return search(s,i+1,temp);
        }


        public boolean search(String s){
            TrieNode temp = root;
            for(var i=0;i<s.length();i++){
                if(temp==null){
                    return false;
                }
                Character c = s.charAt(i);
                temp = temp.children.get(c);
            }
            return temp.isEndOfWord;
        }

        public void insertWords(List<String> words){
            words.stream().forEach(word -> insert(word));
        }

        public String findMinimum(String word){
            TrieNode temp = root;
            StringBuilder prefix = new StringBuilder();
            for(var i=0;i<word.length();i++){
                Character c = word.charAt(i);
                prefix.append(c);
                temp = temp.children.get(c);
                if(temp.frequency == 1){
                    break;
                }
            }
            return prefix.toString();
        }

    }

    public static Map<String,String> shortestUniquePrefix(List<String> words){
        var map = new HashMap<String,String>();
        var minLength = 1;
        for(var i=0;i<words.size();){
            String prefix = words.get(i).substring(0,minLength);
            var j = 0;
            for(;j<words.size();j++){
                if(i==j){
                    continue;
                }
                if(words.get(j).substring(0,minLength).equals(prefix)){
                    break;
                }
            }
            if(j<words.size()){
                minLength++;
            }
            else{
                map.put(words.get(i),prefix);
                i++;
                minLength = 1;
            }
        }
        return map;
    }

    public static void main(String... args){
        List<String> list = Arrays.asList("dog","cat","apple","apricot","fish");
//        var ans = shortestUniquePrefix(list);
         Trie trie = new Trie();
         trie.insertWords(list);
         for(String word:list){
             System.out.println(trie.findMinimum(word) + " for "+word);
         }


//         trie.insert("dogcatp",0, trie.root);
//         System.out.println(trie.search("dogcatpq",0, trie.root));

    }
}
