package practice;

public class SingleValuedTree {

    class Node{
        public int value;
        public Node left;
        public Node right;
        Node(int value){
            this.value = value;
            this.left = this.right = null;
        }
    }

    class BinaryTree{
        public Node root;
        BinaryTree(Node root){
            this.root = root;
        }

        void printInorder(Node root){
            if(root == null)
                return;
            printInorder(root.left);
            System.out.println(root.value);
            printInorder(root.right);
        }

        boolean isUnival(Node root){
            if(root == null){
                return true;
            }

            boolean left = isUnival(root.left);
            boolean right = isUnival(root.right);

            if(!left || !right){
                return false;
            }
            if(root.left!=null && root.left.value != root.value)
                return false;
            if(root.right!=null && root.right.value != root.value)
                return false;
            return true;
        }

        int countUnivals(Node root){
            if(root == null){
                return 0;
            }
            int cl = countUnivals(root.left);
            int cr = countUnivals(root.right);
            if(isUnival(root)){
                return cl + cr + 1;
            }
            return cl+cr;
        }

        class Pair{
            int count;
            boolean isUnival;
            Pair(int count, boolean isUnival){
                this.count = count;
                this.isUnival = isUnival;
            }
        }

        Pair countUnivals2(Node root){
            if(root == null){
                return new Pair(0,true);
            }
            Pair left = countUnivals2(root.left);
            Pair right = countUnivals2(root.right);
            if(!left.isUnival || !right.isUnival){
                return new Pair(left.count + right.count, false);
            }
            if(root.left != null && root.value != root.left.value)
                return new Pair(left.count + right.count, false);

            if(root.right != null && root.value != root.right.value)
                return new Pair(left.count + right.count, false);
            return new Pair(left.count + right.count + 1, true);
        }

    }

    public static void main(String... args){
        var singleValuedTree = new SingleValuedTree();
        var node0 = singleValuedTree.new Node(5);
        var node1 = singleValuedTree.new Node(4);
        var node2 = singleValuedTree.new Node(5);
        var node3 = singleValuedTree.new Node(4);
        var node4 = singleValuedTree.new Node(4);
        var node5 = singleValuedTree.new Node(5);
        node0.left = node1;
        node0.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node5;

        var tree = singleValuedTree.new BinaryTree(node0);
        tree.printInorder(node0);
        System.out.println(tree.countUnivals(node5));
        System.out.println(tree.countUnivals2(node5).count);
    }
}
