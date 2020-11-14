package practice;

import java.util.ArrayList;

public class DaySeven {
    public static int countPointsOfIntersection(Integer[] l1, Integer[] l2){
        var pointsOfIntersection = 0;
        var lineSegments = new ArrayList<ArrayList<Integer>>(l1.length);
        for(var i=0;i<l1.length;i++){
            var temp = new ArrayList<Integer>(2);
            temp.add(l1[i]);
            temp.add(l2[i]);
            lineSegments.add(temp);
        }

        for(var i=0;i<lineSegments.size();i++){
            for(var j=i+1;j<l2.length;j++){
                if(lineSegments.get(i).get(0) < l2[j] && lineSegments.get(i).get(1) > l2[j] || l2[j]<lineSegments.get(i).get(0) && lineSegments.get(i).get(1)<l2[j]){
                    pointsOfIntersection++;
                }
            }
        }

        System.out.println(lineSegments);
        return pointsOfIntersection;
    }

    public static void main(String[] args){
        var l1 = new Integer[]{1,3};
        var l2 = new Integer[]{2,3};
        System.out.println(countPointsOfIntersection(l1,l2));
    }
}
