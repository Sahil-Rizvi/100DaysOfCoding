package practice;

public class DayFifty {


    public static boolean solve(char[][] m, String word){
        for(var i=0;i<m.length;i++){
            for(var j=0;j<m[i].length;j++){
                    if(checkRow(m, i, j, word)){
                        return true;
                    } else if(checkColumn(m, i, j, word)){
                        return true;
                    }
            }
        }
        return false;
    }


    private static boolean checkRow(char[][] m, int i, int j, String word){
        var k = 0;
        if(m[i].length - j < word.length() ){
            return false;
        }
        for(var start = j; start<m[i].length && k < word.length();start++, k++){
            if(word.charAt(k) != m[i][start]){
                return false;
            }
        }
        return true;
    }

    private static boolean checkColumn(char[][] m, int i, int j, String word){
        var k = 0;
        if(m.length - i < word.length() ){
            return false;
        }
        for(var start = i; start<m.length && k < word.length() ;start++, k++){
            if(word.charAt(k) != m[start][j]){
                return false;
            }
        }
        return true;
    }

    public static void main(String... args){
        var ch = new char[][]{
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}
        };

        System.out.println(solve(ch, "FACID"));
        System.out.println(solve(ch, "MASS"));
    }

}
