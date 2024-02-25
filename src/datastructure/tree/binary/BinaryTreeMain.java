package datastructure.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode {

    private String value;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

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

    public void levelOrderTraversal() {
        Queue<BinaryTreeNode> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(root);
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

    }


}
