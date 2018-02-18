package com.practice.linkedlist;

public class LinkedListUtils {

    public static ListNode getExampleList(){
        ListNode head = new ListNode(0);

        ListNode m, n;
        m = head;
        for(int i = 1; i<10; i++){
            n = new ListNode(i);
            m.next = n;
            m = m.next;
        }

        return head;
    }

    public static ListNode getLastNode(ListNode node){
        while(node.getNext() != null){
            node = node.getNext();
        }

        return node;
    }

    public static void addAtEnd(ListNode head, ListNode n){
        ListNode lastNode = getLastNode(head);
        lastNode.next = n;
    }

    public static ListNode addAtStart(ListNode head, ListNode n){
        n.next = head;
        head = n;

        return head;
    }

    public static void deleteAtEnd(ListNode n){
        while(n.next != null){
            n = n.next;
        }
        n = null;
    }

    public static String toString(ListNode n){
        String list = "";
        while(n != null){
            list = list + n.data+"  ";
            n = n.next;
        }
        return list;
    }

    public static int getLengthRecursive(ListNode node){
        if(node == null){
            return 0;
        }else{
            return 1 + getLengthRecursive(node.next);
        }
    }

    public static int getLengthIterative(ListNode node){
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }

        return count;
    }

    public static ListNode deleteNodeAtPosition(int pos, ListNode head){
        if(pos == 0){
            head = head.next;
        }else{
            ListNode prev = head.next, node = head.next;
            int count = 1;
            while(node != null){
                if(count == pos)
                {
                    prev.next = node.next;
                    break;
                }

                prev = node;
                node = node.next;
                count++;
            }
        }

        return head;
    }

    public static ListNode deleteNodeByKey(int key, ListNode head){
        if(head.data == key){
            head = head.next;
        }else{
            ListNode prev = head.next, node = head.next;
            while(node != null){
                if(node.data == key)
                {
                    prev.next = node.next;
                    break;
                }

                prev = node;
                node = node.next;
            }
        }

        return head;
    }

    public static ListNode searchIterative(ListNode head, int key){
        ListNode result = null;
        if(head.data == key){
            result = head;
        }else{
            ListNode node = head.next;
            while(node != null){
                if(node.data == key){
                    result = node;
                    break;
                }
                node = node.next;
            }
        }

        return result;
    }

    public static ListNode searchRecursive(ListNode node, int key){
        if(node == null){
            return null;
        }else if(key == node.data){
            return node;
        }else{
            return searchRecursive(node.next, key);
        }
    }

    //TODO: get previous node
    public static ListNode getPreviousNode(ListNode head, int key){
        ListNode prev = null, cur = head;

        while(cur != null){
            if(cur.data == key){
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        return prev;
    }

    public static void swapNodesWithouSwappingData(ListNode head, int a, int b){
        ListNode prevA, prevB, refA, refB;

        prevA = getPreviousNode(head, a);
        prevB = getPreviousNode(head, b);

        refA = searchRecursive(head, a);
        refB = searchRecursive(head, b);

        prevA.next = refB;
        refB.next = refA.next;
        prevB.next = refA;
        refA.next = refB.next;
    }

    public ListNode getMerged(ListNode sHead, ListNode bHead){

        ListNode sCur = sHead;
        //ListNode sPrev = sHead;
        while(sCur != null){//small list

            int curItem = sCur.getData();

            ListNode bCur = bHead;
            ListNode bPrev = bHead;
            while(bCur != null){//big list

                if(curItem > bCur.getData()){
                    insertNextTo(bPrev, sCur.getData());
                    break;
                }

                bPrev = bCur;
                bCur = bCur.getNext();
            }//big list ends
            //sPrev = sCur;
            sCur = sCur.getNext();
        }//small list ends

        return bHead;
    }

    private void insertNextTo(ListNode bPrev, int data) {
        ListNode newListNode = new ListNode(data);

        newListNode.setNext(bPrev.getNext());
        bPrev.setNext(newListNode);
    }

    public static ListNode getNodeByIndex(ListNode head, int index){
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            if(count == index){
                return cur;
            }
            count++;
            cur = cur.next;
        }

        return cur;
    }

    public static ListNode getMiddleNode(ListNode head){
        ListNode slowPtr, fastPtr;
        slowPtr = fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }

    public static ListNode getNthFromEnd(ListNode head, int index){
        int length = getLengthRecursive(head);
        return getNodeByIndex(head, length - index);
    }
}
