package com.practice.tree;

/**
 * Created by Bhargav on 09-07-2017.
 */
public class BinTree {
    private TreeNode root;

    public BinTree(TreeNode root) {
        this.root = root;
    }

    public BinTree() {
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
