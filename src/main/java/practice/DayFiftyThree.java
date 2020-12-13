package practice;

public class DayFiftyThree {

    public static void printSpiral(int[][] m){

        var startRow = 0;
        var startColumn = 0;
        var endRow = m.length-1;
        var endColumn = m[0].length-1;

        var counter = m.length * m[0].length;
        while(counter>0){
            for(var i = startColumn;i<=endColumn;i++){
                System.out.println(m[startRow][i]);
                counter--;
            }
            startRow++;

            for(var i = startRow;i<=endRow;i++){
                System.out.println(m[i][endColumn]);
                counter--;
            }
            endColumn--;

            for(var i= endColumn; i>=startColumn; i--){
                System.out.println(m[endRow][i]);
                counter--;
            }
            endRow--;

            for(var i= endRow; i>=startRow; i--){
                System.out.println(m[i][startColumn]);
                counter--;
            }
            startColumn++;
        }

    }

    public static void main(String... args){
        var m = new int[][]{
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        printSpiral(m);
    }

}
