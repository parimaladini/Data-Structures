package Binary_Search_Trees;
import java.util.*;


public class Parimal {
    
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx=-1;

        // build tree preorder
        static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // PreOrder Traversal
        public static void PreOrder(Node root){
            if(root==null){
                return;
            }

            System.out.print(root.data+" ");
            PreOrder(root.left);
            PreOrder(root.right);
        }

        // InOrder Traversal
        public static void InOrder(Node root){
            if(root==null){
                return;
            }

            InOrder(root.left);
            System.out.print(root.data+ " ");
            InOrder(root.right);
        }

        // PostOrder Traversal
        public static void PostOrder(Node root){
            if(root==null){
                return;
            }

            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data);
        }

        // LevelOrder Traversal
        public static void LevelOrder(Node root){
            if(root==null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node temp = q.remove();

                if(temp==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(temp.data+" ");
                    if(temp.left!=null){
                        q.add(temp.left);
                    }
                    if(temp.right!=null){
                        q.add(temp.right);
                    }
                }
            }
        }

        // Height of the BinaryTree
        public static int Height(Node root){
            if(root==null){
                return 0;
            }

            int lh = Height(root.left);
            int rh = Height(root.right);

            return Math.max(lh, rh) + 1;
        }

        // Count the no of Nodes
        public static int countNodes(Node root){
            if(root==null){
                return 0;
            }

            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);

            return leftCount+rightCount+1;
        }

        // Sum of values of all Nodes
        public static int sumNodes(Node root){
            if(root==null){
                return 0;
            }

            int leftSum = sumNodes(root.left);
            int rightSum = sumNodes(root.right);

            return leftSum+rightSum+root.data;
        }
    }
}
