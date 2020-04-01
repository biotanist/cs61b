package org.wangc.cs61b.l02;

public class SLList {

    private static class IntNode {

        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }

    }


    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }


    public static void main(String[] args) {
        SLList l = new SLList(10);
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void addLast(int x) {
        IntNode p = first;

        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);

    }

    /*public int size() {

    }*/

    public int getFirst() {
        return first.item;
    }


}
