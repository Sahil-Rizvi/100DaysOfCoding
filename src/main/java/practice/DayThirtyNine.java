package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DayThirtyNine {

    private class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    private class Result{
        int sum;
        List<Node> list;

        public Result(int sum, List<Node> list) {
            this.sum = sum;
            this.list = list;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public List<Node> getList() {
            return list;
        }

        public void setList(List<Node> list) {
            this.list = list;
        }
    }

    public int minPathSum(Node node){
        if(null==node){
            return 0;
        }
        var leftSum = minPathSum(node.left);
        var rightSum = minPathSum(node.right);
        return Math.min(leftSum, rightSum) + node.data;
    }

    public Result minPathSumResult(Node node){
        if(null==node){
            return new Result(0, new ArrayList<Node>());
        }
        var leftSum = minPathSumResult(node.left);
        var rightSum = minPathSumResult(node.right);

        var sum = node.data;
        var path = new ArrayList<Node>();
        path.add(node);
        if(leftSum.sum<rightSum.sum){
            sum +=leftSum.sum;
            path.addAll(leftSum.list);
        } else{
            sum +=rightSum.sum;
            path.addAll(rightSum.list);
        }
        return new Result(sum, path);
    }

    @Test
    public void test(){
        var node1 = new Node(10);
        var node2 = new Node(5);
        var node3 = new Node(5);
        var node4 = new Node(2);
        var node5 = new Node(1);
        var node6 = new Node(-1);

        node1.left = node2;
        node1.right = node3;

        node2.right = node4;

        node3.right = node5;
        node5.left = node6;

        Assert.assertEquals(15,minPathSum(node1));
        var res = minPathSumResult(node1);
        Assert.assertEquals(15,res.sum);
        Assert.assertEquals(List.of(node1, node3, node5, node6), res.list);
    }
}
