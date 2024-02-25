package datastructure.tree;

import java.io.Serializable;
import java.util.ArrayList;

public class Tree extends AbstractMethodError implements Serializable {
    public static void main(String[] args) {
        TreeNode drinks = new TreeNode("drinks");
        TreeNode hot = new TreeNode("hot");
        TreeNode cold = new TreeNode("cold");

        drinks.addChild(hot);
        drinks.addChild(cold);

        TreeNode tea = new TreeNode("tea");
        TreeNode coffee = new TreeNode("coffee");
        hot.addChild(tea);
        hot.addChild(coffee);

        TreeNode wine = new TreeNode("wine");
        TreeNode bear = new TreeNode("bear");
        cold.addChild(wine);
        cold.addChild(bear);

        System.out.println(drinks.print(0));

    }




}

class TreeNode{
    String data;
    ArrayList<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }

    public void addChild(TreeNode treeNode){
        this.children.add(treeNode);
    }

    public String print(int level){
        String ret="";
        ret=" ".repeat(level)+data+"\n";
        for (TreeNode node:this.children){
            ret += node.print(level+1);
        }
        return ret;
    }
}
