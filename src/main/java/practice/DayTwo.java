package practice;

public class DayTwo {

    class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    class BinaryTree{
        public Node root;

        public BinaryTree(Node root) {
            this.root = root;
        }

        void printInorder(Node root){
            if(root!=null){
                printInorder(root.left);
                System.out.println(root.data);
                printInorder(root.right);
            }
        }

        // time complexity O(n)
        boolean isUnival(Node root){
            if(root == null){
                return true;
            }
            if(root.left!= null && root.left.data != root.data)
                return false;
            if(root.right!= null && root.right.data != root.data)
                return false;
            if(isUnival(root.left) && isUnival(root.right)){
                return true;
            }
            return false;
        }

        // time complexity O(n^2)
        int countUnival(Node root){
            if(root == null){
                return 0;
            }
            int leftCount = countUnival(root.left);
            int rightCount = countUnival(root.right);
            if(isUnival(root)){
                return leftCount + rightCount + 1;
            }
            return leftCount + rightCount;
        }

        class Pair{
            int count;
            boolean univalFlag;
            Pair(int count, boolean univalFlag){
                this.count = count;
                this.univalFlag = univalFlag;
            }
        }

        Pair countAndCheckUnival(Node root){
            if(root == null){
                return new Pair(0, true);
            }
            Pair leftRes = countAndCheckUnival(root.left);
            Pair rightRes = countAndCheckUnival(root.right);
            boolean isUnival = true;
            if(!leftRes.univalFlag || !rightRes.univalFlag)
                isUnival = false;
            if(root.left!=null && root.data != root.left.data)
                isUnival = false;
            if(root.right!=null && root.data != root.right.data)
                isUnival = false;
            if(isUnival){
                return new Pair(leftRes.count + rightRes.count+1 , true);
            }
            return new Pair(leftRes.count + rightRes.count , false);
        }



    }

    public static void main(String... args){
        var node0 = new DayTwo().new Node(1);
        var node1 = new DayTwo().new Node(3);
        var node2 = new DayTwo().new Node(2);
        var node3 = new DayTwo().new Node(2);
        var node4 = new DayTwo().new Node(2);
        var node5 = new DayTwo().new Node(2);
        var node6 = new DayTwo().new Node(1);
        node0.left = node1;
        node0.right = node2;

        node2.left = node3;
        node2.right = node4;

        node4.right = node5;

        var binaryTree = new DayTwo().new BinaryTree(node0);
        binaryTree.printInorder(node0);
        System.out.println(binaryTree.countAndCheckUnival(node0).count);
    }


}
