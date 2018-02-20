package com.dstest.practice;

import com.practice.tree.BinTreeUtils;
import com.practice.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinTreeTest {

    @Test
    public void preOrderRecursive(){
        TreeNode root = BinTreeUtils.getSampleTree();
        assertEquals("1 2 4 5 3 6 7",BinTreeUtils.preOrderRecursive(root));
    }

    @Test
    public void inOrderRecursive(){
        TreeNode root = BinTreeUtils.getSampleTree();
        assertEquals("4 2 5 1 6 3 7",BinTreeUtils.inOrderRecursive(root));
    }

    @Test
    public void postOrderRecursive(){
        TreeNode root = BinTreeUtils.getSampleTree();
        assertEquals("4 5 2 6 7 3 1",BinTreeUtils.postOrderRecursive(root));
    }

    @Test
    public void levelOrderRecursive(){
        TreeNode root = BinTreeUtils.getSampleTree();
        assertEquals("1 2 3 4 5 6 7",BinTreeUtils.levelOrderRecursive(root));
    }
}
