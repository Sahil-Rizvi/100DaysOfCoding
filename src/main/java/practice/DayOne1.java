package practice;

import java.util.Arrays;
import java.util.HashSet;

public class DayOne1 {

    public static boolean solveUsing2Pointer(Integer[] arr, Integer k){
        Arrays.sort(arr);
        var start = 0;
        var end = arr.length - 1;
        while(start < end){
            var tempSum = arr[start] + arr[end];
            if(tempSum == k){
                return true;
            }
            if(tempSum < k){
                start++;
            }
            else{
                end--;
            }
        }
        return false;
    }

    public static boolean solveUsingHashSet(Integer[] arr, Integer k){
        var visited = new HashSet<Integer>();
        for(var element: arr){
            if(visited.contains(k - element)){
                return true;
            }
            visited.add(element);
        }
        return false;
    }

    public static int binarySearch(Integer[] arr, int target, int low, int high){
        if(low > high){
            return -1;
        }
        if(low==high){
            if(arr[low]==target){
                return low;
            }
            return -1;
        }
        var mid = low + (high-low)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid] < target){
            return binarySearch(arr, target, low, mid-1);
        }
        return binarySearch(arr, target, mid+1, high);
    }

    public static boolean usingBinarySearch(Integer[] arr,Integer k){
        Arrays.sort(arr);
        for(var i=0;i<arr.length;i++){
            var j = binarySearch(arr, k - arr[i], 0, arr.length-1);
            if(j==-1){
                continue;
            }
            if(j!=i){
                return true;
            }
            else{
                if(j+1< arr.length && arr[j+1] == k - arr[i]){
                    return true;
                }
                if(j-1 >=0 && arr[j-1] == k-arr[i]){
                    return true;
                }
            }
        }
        return false;
    }


    private class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static boolean isUnival(Node node){
        if(node == null){
            return true;
        }
        var left = isUnival(node.left);
        var right = isUnival(node.right);
        if(!left || !right){
            return false;
        }
        if(node.left!=null && node.left.data!=node.data){
            return false;
        }
        if(node.right!=null && node.right.data!=node.data){
            return false;
        }
        return true;
    }

    public static int countUnival(Node node){
        if(node == null){
            return 0;
        }
        var left = countUnival(node.left);
        var right = countUnival(node.right);
        if(isUnival(node)){
            return left + right + 1;
        }
        return left + right;
    }

    private static class Pair{
        int count;
        boolean flag;

        public Pair(int i, boolean b) {
            this.count = i;
            this.flag = b;
        }
    }

    public static Pair countUnivals(Node node){
        if(node == null){
            return new Pair(0, true);
        }
        Pair left = countUnivals(node.left);
        Pair right = countUnivals(node.right);
        var count = left.count + right.count;
        if(!left.flag || !right.flag){
            return new Pair(count, false);
        }
        if(node.left!=null && node.left.data != node.data){
            return new Pair(count, false);
        }
        if(node.right!=null && node.right.data != node.data){
            return new Pair(count, false);
        }
        return new Pair(count+1, true);
    }

    public static void main(String... args) {
        var node0 = new DayOne1().new Node(0);
        var node1 = new DayOne1().new Node(1);
        var node2 = new DayOne1().new Node(0);
        var node3 = new DayOne1().new Node(1);
        var node4 = new DayOne1().new Node(0);
        var node5 = new DayOne1().new Node(1);
        var node6 = new DayOne1().new Node(1);
        node0.left = node1;
        node0.right = node2;

        node2.left = node3;
        node2.right = node4;

        node3.left = node5;
        node3.right = node6;
        System.out.println(new DayOne1().isUnival(node0));
        System.out.println(new DayOne1().countUnival(node0));
        System.out.println(new DayOne1().countUnivals(node0).flag);
    }

}
