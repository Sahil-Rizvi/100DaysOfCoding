package practice;

public class Test3 {
    private static Boolean getFlagForExactSearch(String boostKeywords, String keyType) {
        if (!("exact".equals(keyType) || (boostKeywords.contains("'") || boostKeywords.contains("\"")))) {
            String[] keywordsArray = boostKeywords.split("\\s");
            return keywordsArray.length == 2 || keywordsArray.length == 3;
        }
        return Boolean.FALSE;
    }
    
    public static void main(String... args){
        System.out.println(getFlagForExactSearch("abc def","exact1"));
    }

}
