package datastructure.tree.binary;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

class BinaryTreeNode {

    private String value;

    public BinaryTreeNode left;

    public BinaryTreeNode right;

    public int height;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class BinaryTreeLinkedList{
    public BinaryTreeNode root;

    public BinaryTreeLinkedList() {
        this.root = null;
    }
//DFS
    void preOrder(BinaryTreeNode binaryTreeNode){
        if(binaryTreeNode==null){
            return;
        }
        System.out.print(binaryTreeNode.getValue()+" ");
        preOrder(binaryTreeNode.getLeft());
        preOrder(binaryTreeNode.getRight());
    }


    public void inOrder(BinaryTreeNode binaryTreeNode) {
        if(binaryTreeNode==null){
            return;
        }
        inOrder(binaryTreeNode.getLeft());
        System.out.print(binaryTreeNode.getValue()+" ");
        inOrder(binaryTreeNode.getRight());

    }

    public void postOrder(BinaryTreeNode binaryTreeNode) {
        if(binaryTreeNode==null){
            return;
        }
        postOrder(binaryTreeNode.getLeft());
        postOrder(binaryTreeNode.getRight());

        System.out.print(binaryTreeNode.getValue()+" ");

    }

    //BFS
    public void levelOrderTraversal() {
        Queue<BinaryTreeNode> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(root);
        if(root==null){
            return;
        }
        while (!levelOrderQueue.isEmpty()){
            BinaryTreeNode node = levelOrderQueue.remove();
            System.out.print(node.getValue() +" ");
            if(node.getLeft()!=null){
                levelOrderQueue.add(node.getLeft());
            }
            if (node.getRight()!=null){
                levelOrderQueue.add(node.getRight());
            }
        }
    }

    public void search(String searchKey){
        Queue<BinaryTreeNode> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(root);
        while (!levelOrderQueue.isEmpty()){
            BinaryTreeNode node = levelOrderQueue.remove();
            if(searchKey.equals(node.getValue())){
                System.out.println("Value fount "+searchKey);
                return;
            }else{
                if(node.getLeft()!=null){
                    levelOrderQueue.add(node.getLeft());
                }
                if (node.getRight()!=null){
                    levelOrderQueue.add(node.getRight());
                }
            }
        }
        System.out.println("Value not found");
    }

    public void insertNode(String string) {
        BinaryTreeNode treeNode = new BinaryTreeNode();
        treeNode.setValue(string);
        if(null==root){
            this.root=treeNode;
            System.out.println("new node added at root");
            return;
        }
        Queue<BinaryTreeNode> binaryTreeNodes = new LinkedList<>();

        binaryTreeNodes.add(root);
        while (!binaryTreeNodes.isEmpty()){
            BinaryTreeNode node = binaryTreeNodes.remove();
            if(node.getLeft()==null){
                node.setLeft(treeNode);
                System.out.println("Node added at left of node"+node.getValue());
                break;
            }else if(node.getRight()==null){
                node.setRight(treeNode);
                System.out.println("Node added at Right of node"+node.getValue());
                break;
            }else {
                binaryTreeNodes.add(node.getLeft());
                binaryTreeNodes.add(node.getRight());
            }
        }
    }


    // Get Deepest node
    public BinaryTreeNode getDeepestNode() {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryTreeNode presentNode = null;
        while (!queue.isEmpty()) {
            presentNode = queue.remove();
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        return presentNode;
    }


    //always delete deepest node
    public void deleteDeepestNode() {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryTreeNode previousNode, presentNode = null;
        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();
            if (presentNode.left == null) {
                previousNode.right = null;
                return;
            } else if (presentNode.right == null) {
                presentNode.left = null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);

        }
    }

    // Delete Given node
    void deleteNode(String value) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode presentNode = queue.remove();
            if (Objects.equals(presentNode.getValue(), value)) {
                presentNode.setValue(getDeepestNode().getValue());
                deleteDeepestNode();
                System.out.println("The node is deleted!");
                return;
            } else {
                if (presentNode.left != null) queue.add(presentNode.left);
                if (presentNode.right != null) queue.add(presentNode.right);
            }
        }
        System.out.println("The node does not exist in this BT");

    }

    // Delete Binary Tree
    void deleteBT() {
        root = null;
        System.out.println("BT has been successfully deleted!");
    }
}

public class BinaryTreeMain{
    public static void main(String[] args) {
        BinaryTreeLinkedList binaryTree = new BinaryTreeLinkedList();
        BinaryTreeNode root = new BinaryTreeNode();
        root.setValue("N1");
        BinaryTreeNode N2 = new BinaryTreeNode();
        N2.setValue("N2");
        BinaryTreeNode N3 = new BinaryTreeNode();
        N3.setValue("N3");
        BinaryTreeNode N4 = new BinaryTreeNode();
        N4.setValue("N4");
        BinaryTreeNode N5 = new BinaryTreeNode();
        N5.setValue("N5");
        BinaryTreeNode N6 = new BinaryTreeNode();
        N6.setValue("N6");
        BinaryTreeNode N7 = new BinaryTreeNode();
        N7.setValue("N7");
        BinaryTreeNode N8 = new BinaryTreeNode();
        N8.setValue("N8");
        BinaryTreeNode N9 = new BinaryTreeNode();
        N9.setValue("N9");

        binaryTree.root=root;

     root.setLeft(N2);
     root.setRight(N3);
     N2.setLeft(N4);
     N2.setRight(N5);
        N3.setLeft(N6);
        N3.setRight(N7);
        N4.setRight(N9);
        N4.setLeft(N8);

        System.out.println("Preorder traversal ");
        binaryTree.preOrder(root);
        System.out.println();


        System.out.println("Inorder traversal ");
        binaryTree.inOrder(root);
        System.out.println();

        System.out.println("PostOrder traversal ");
        binaryTree.postOrder(root);
        System.out.println();

        System.out.println("level order traversal ");
        binaryTree.levelOrderTraversal();
        System.out.println();

        Scanner  scanner = new Scanner(System.in);
        String searchKey = scanner.next();

       // binaryTree.search(searchKey);

        binaryTree.insertNode(searchKey);
        binaryTree.insertNode("n11");
        binaryTree.insertNode("n12");
        binaryTree.insertNode("n13");
        binaryTree.insertNode("n14");
        binaryTree.insertNode("n15");
        binaryTree.insertNode("n16");
        binaryTree.insertNode("n17");

        binaryTree.deleteNode("N2");
        binaryTree.levelOrderTraversal();

        binaryTree.deleteBT();
        binaryTree.levelOrderTraversal();

    }


}
