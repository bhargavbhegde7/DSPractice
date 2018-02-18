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
}
