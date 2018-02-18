package com.dstest.practice;

import com.practice.linkedlist.LinkedListUtils;
import com.practice.linkedlist.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    @Test
    public void getExampleList(){
        ListNode head = LinkedListUtils.getExampleList();
        assertEquals("0  1  2  3  4  5  6  7  8  9  ", LinkedListUtils.toString(head));
    }

    @Test
    public void getLastNode(){
        ListNode head = LinkedListUtils.getExampleList();
        assertEquals(9, LinkedListUtils.getLastNode(head).data);
    }

    @Test
    public void addAtEnd(){
        ListNode head = LinkedListUtils.getExampleList();
        LinkedListUtils.addAtEnd(head, new ListNode(25));
        assertEquals(25, LinkedListUtils.getLastNode(head).data);
    }

    @Test
    public void addAtStart(){
        ListNode head = LinkedListUtils.getExampleList();
        head =  LinkedListUtils.addAtStart(head, new ListNode(50));
        assertEquals(50, head.data);
    }

    @Test
    public void getLengthRecursive(){
        ListNode head = LinkedListUtils.getExampleList();
        assertEquals(10, LinkedListUtils.getLengthRecursive(head));
    }

    @Test
    public void getLengthIterative(){
        ListNode head = LinkedListUtils.getExampleList();
        assertEquals(10, LinkedListUtils.getLengthIterative(head));
    }

    @Test
    public void deleteNodeAtPositionLast(){
        ListNode head = LinkedListUtils.getExampleList();
        head = LinkedListUtils.deleteNodeAtPosition(9,head);
        assertEquals("0  1  2  3  4  5  6  7  8  ", LinkedListUtils.toString(head));
    }

    @Test
    public void deleteNodeAtPositionFirst(){
        ListNode head = LinkedListUtils.getExampleList();
        head = LinkedListUtils.deleteNodeAtPosition(0,head);
        assertEquals("1  2  3  4  5  6  7  8  9  ", LinkedListUtils.toString(head));
    }

    @Test
    public void deleteNodeAtPositionMiddle(){
        ListNode head = LinkedListUtils.getExampleList();
        head = LinkedListUtils.deleteNodeAtPosition(4,head);
        assertEquals("0  1  2  3  5  6  7  8  9  ", LinkedListUtils.toString(head));
    }

    @Test
    public void deleteNodeItemNotFound(){
        ListNode head = LinkedListUtils.getExampleList();
        head = LinkedListUtils.deleteNodeAtPosition(25,head);
        assertEquals("0  1  2  3  4  5  6  7  8  9  ", LinkedListUtils.toString(head));
    }

    @Test
    public void deleteNodeByKeyLast(){
        ListNode head = LinkedListUtils.getExampleList();
        head = LinkedListUtils.deleteNodeByKey(9,head);
        assertEquals("0  1  2  3  4  5  6  7  8  ", LinkedListUtils.toString(head));
    }

    @Test
    public void deleteNodeByKeyFirst(){
        ListNode head = LinkedListUtils.getExampleList();
        head = LinkedListUtils.deleteNodeByKey(0,head);
        assertEquals("1  2  3  4  5  6  7  8  9  ", LinkedListUtils.toString(head));
    }

    @Test
    public void deleteNodeByKeyMiddle(){
        ListNode head = LinkedListUtils.getExampleList();
        head = LinkedListUtils.deleteNodeByKey(4,head);
        assertEquals("0  1  2  3  5  6  7  8  9  ", LinkedListUtils.toString(head));
    }

    @Test
    public void deleteNodeByKeyNotFound(){
        ListNode head = LinkedListUtils.getExampleList();
        head = LinkedListUtils.deleteNodeByKey(25,head);
        assertEquals("0  1  2  3  4  5  6  7  8  9  ", LinkedListUtils.toString(head));
    }

    @Test
    public void searchIterativeLastElement(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.searchIterative(head, 9);
        assertEquals(9, result.data);
    }

    @Test
    public void searchIterativeFirstElement(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.searchIterative(head, 0);
        assertEquals(0, result.data);
    }

    @Test
    public void searchIterativeMiddleElement(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.searchIterative(head, 0);
        assertEquals(0, result.data);
    }

    @Test
    public void searchIterativeNotFound(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.searchIterative(head, 25);
        assertEquals(null, result);
    }

    @Test
    public void searchRecursiveLastElement(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.searchRecursive(head, 9);
        assertEquals(9, result.data);
    }

    @Test
    public void searchRecursiveFirstElement(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.searchRecursive(head, 0);
        assertEquals(0, result.data);
    }

    @Test
    public void searchRecursiveMiddleElement(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.searchRecursive(head, 0);
        assertEquals(0, result.data);
    }

    @Test
    public void searchRecursiveNotFound(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.searchRecursive(head, 25);
        assertEquals(null, result);
    }

    /*@Test
    public void swapNodesWithouSwappingData(){
        ListNode head = LinkedListUtils.getExampleList();
        LinkedListUtils.swapNodesWithouSwappingData(head, 1, 4);
        assertEquals("0  4  2  3  1  5  6  7  8  9  ", LinkedListUtils.toString(head));
    }*/

    @Test
    public void getNodeByIndexLast(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.getNodeByIndex(head, 9);
        assertEquals(9, result.data);
    }

    @Test
    public void getNodeByIndexFirst(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.getNodeByIndex(head, 0);
        assertEquals(0, result.data);
    }

    @Test
    public void getNodeByIndexMiddle(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.getNodeByIndex(head, 7);
        assertEquals(7, result.data);
    }

    @Test
    public void getNodeByIndexNotFound(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.getNodeByIndex(head, 25);
        assertEquals(null, result);
    }

    @Test
    public void getMiddleNodeEven(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.getMiddleNode(head);
        assertEquals(5, result.data);
    }

    @Test
    public void getMiddleNodeOdd(){
        ListNode head = LinkedListUtils.getExampleList();
        LinkedListUtils.addAtEnd(head, new ListNode(10));
        ListNode result = LinkedListUtils.getMiddleNode(head);
        assertEquals(5, result.data);
    }

    @Test
    public void getNthFromEnd(){
        ListNode head = LinkedListUtils.getExampleList();
        ListNode result = LinkedListUtils.getNthFromEnd(head, 4);
        assertEquals(6, result.data);
    }
}
