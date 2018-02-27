package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinTreeUtils {

    /**
     *
     * @return        1
     *              /   \
     *             /     \
     *           2        3
     *         /  \     /  \
     *       4     5  6     7
     */
    public static TreeNode getSampleTree(){
        TreeNode root = new TreeNode(1);

        root.setLeftChild(new TreeNode(2));
        root.setRightChild(new TreeNode(3));

        root.getLeftChild().setLeftChild(new TreeNode(4));
        root.getLeftChild().setRightChild(new TreeNode(5));

        root.getRightChild().setLeftChild(new TreeNode(6));
        root.getRightChild().setRightChild(new TreeNode(7));

        return root;
    }

    //1245367
    public static String preOrderRecursive(TreeNode root){
        if(root == null){
            return "";
        }

        return (
                root.getData() + " "
                + preOrderRecursive(root.getLeftChild()) + " "
                + preOrderRecursive(root.getRightChild())
        ).trim();
    }

    //4251637
    public static String inOrderRecursive(TreeNode root){
        if(root == null){
            return "";
        }

        return (
                inOrderRecursive(root.getLeftChild()) + " "
                + root.getData() + " "
                + inOrderRecursive(root.getRightChild())
        ).trim();
    }

    //4526731
    public static String postOrderRecursive(TreeNode root){
        if(root == null){
            return "";
        }

        return (
                postOrderRecursive(root.getLeftChild()) + " "
                + postOrderRecursive(root.getRightChild()) + " "
                + root.getData()
        ).trim();
    }

    /*public static String level(Queue q, TreeNode cur){
        if(cur == null){
            return " ";
        }
        return (cur.getData()
                +" "
                +cur.getLeftChild()==null?"":level(q, cur.getLeftChild())
                +" "
                +cur.getRightChild()==null?"":level(q, cur.getRightChild())
                +" "
        ).trim();
    }*/

    public static void level2(Queue q, TreeNode cur){
        if(cur!=null){
            System.out.println(cur.getData());
            q.remove();

            if(cur.getLeftChild()!=null){
                q.add(cur.getLeftChild());
            }

            if(cur.getRightChild()!=null){
                q.add(cur.getRightChild());
            }

            level2(q, cur.getLeftChild());
            level2(q, cur.getRightChild());
        }
    }

    public static void levelOrderRecursive(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        //return level(q, root);
        level2(q, root);
    }

    public static String levelOrderIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        String output = "";
        while(!q.isEmpty()){
            TreeNode cur = q.element();
            output = output+" "+cur.getData();
            q.remove();

            if(cur.getLeftChild()!=null) {
                q.add(cur.getLeftChild());
            };
            if(cur.getRightChild()!=null) {
                q.add(cur.getRightChild());
            };
        }

        return output.trim();
    }
}
