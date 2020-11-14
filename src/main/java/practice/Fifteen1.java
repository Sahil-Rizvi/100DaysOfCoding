package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fifteen1 {
    private static class TrieNode{
        Character character;
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        int frequency;

        TrieNode(){
            this.character = null;
            this.children = new HashMap<>();
            this.isEndOfWord = false;
            this.frequency = 0;
        }
        TrieNode(Character character, int frequency) {
            this.character = character;
            this.children = new HashMap<>();
            this.frequency = frequency;
            this.isEndOfWord = false;
        }
    }

     static class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }

        void insert(String s){
            TrieNode temp = root;
            for(var i=0;i<s.length();i++){
                var childNode = temp.children.get(s.charAt(i));
                if(childNode == null){
                    childNode = new TrieNode(s.charAt(i),1);
                    temp.children.put(s.charAt(i),childNode);
                }
                else{
                    childNode.frequency++;
                }
                temp = childNode;
            }
            temp.isEndOfWord = true;
        }

     void insertRec(String str, int s, TrieNode root){
        if(s==str.length()){
            root.isEndOfWord = true;
            return;
        }
        var ch = str.charAt(s);
        var temp = root.children.get(ch);
        if(temp == null){
            temp = new TrieNode(ch,0);
            root.children.put(ch, temp);
        }
        else{
            root.children.put(ch, temp);
        }
        temp.frequency++;
        insertRec(str, s+1, temp);
    }

    boolean searchRec(String str, int s, TrieNode trieNode){
        if(str.length() ==s ){
            return trieNode.isEndOfWord;
        }
        var ch = trieNode.children.get(str.charAt(s));
        if(ch==null){
            return false;
        }
        return searchRec(str, s+1, ch);
    }

    String findUniqueShortestPrefix(String str){
            StringBuilder sb = new StringBuilder();
            TrieNode temp = root;
            for(int i=0;i<str.length();i++){
                var ch = temp.children.get(str.charAt(i));
                if(ch.frequency == 1){
                    return sb.append(ch.character).toString();
                }
                else{
                    sb.append(str.charAt(i));
                }
                temp = ch;
            }
            return sb.toString();
    }
    }


    public static void main(String... args){
        Trie t = new Trie();
        t.insertRec("dog", 0, t.root);
        t.insertRec("cat", 0, t.root);
        t.insertRec("apple", 0, t.root);
        t.insertRec("apricot", 0, t.root);
        t.insertRec("fish", 0, t.root);

        System.out.println(t.searchRec("dog",0,t.root));
        System.out.println(t.searchRec("cat",0,t.root));
        System.out.println(t.searchRec("apple",0,t.root));
        System.out.println(t.searchRec("apricot",0,t.root));
        System.out.println(t.searchRec("fish",0,t.root));

        var words = Arrays.asList("dog","cat","apple","apricot","fish");
        for(String word:words){
            System.out.println(word+ "->" +t.findUniqueShortestPrefix(word));
        }
    }
}
